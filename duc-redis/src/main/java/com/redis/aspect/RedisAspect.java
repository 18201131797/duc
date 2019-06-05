package com.redis.aspect;

import com.google.gson.Gson;
import com.redis.annotation.Redis;
import com.redis.core.RedisTemplates;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0.0
 * @Description: redis注解拦截
 * @Author: liwt
 * @date: 2019/6/5 13:33
 */
@Aspect
@Component
@Slf4j
public class RedisAspect {

    private final int retryCount = 10;

    @Autowired
    private RedisTemplates redisTemplates;

    @Pointcut("@annotation(com.redis.annotation.Redis)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, Redis anno) {
        MethodSignature signature = (MethodSignature) invocation.getSignature();
        Method method = signature.getMethod();
        Object result = null;
        String key = "";
        String value = "";
        try {
            key = anno.key();
            value = redisTemplates.get(key);
            Type returnType = method.getGenericReturnType();
            result = getResult(value, result, returnType);
        } catch (Exception e) {
            log.error("获取缓存失败：" + key, e);
        } finally {
            if (result == null) {
                result = getValue(key, invocation);
                if (StringUtils.isNotBlank(key) && result != null) {
                    redisTemplates.setEx(key, result, anno.timeout(), TimeUnit.SECONDS);
                }
            }
        }
        return result;
    }

    /**
     * @version 1.0.0.0
     * @Description: 获取 value 防止缓存穿透
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public synchronized Object getValue(String key, ProceedingJoinPoint invocation) {
        Object result = null;
        try {
            // Redis 开始增量计次：10次。如果10分钟内10次连续查询数据库，则10分钟内返回空
            Long count = increment(key, 10 * 60L);
            if (count >= retryCount) {
                return result;
            }
            result = invocation.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }


    public Object getResult(String value, Object result, Type returnType) {
        Gson gson = new Gson();
        result = gson.fromJson(value, returnType);
        return result;
    }

    /**
     * @version 1.0.0.0
     * @Description: 自增缓存并设置过期时间
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public Long increment(String key, Long timeout) {
        key = key + "-count";
        Long count = redisTemplates.incrBy(key, 1);
        if (count < retryCount) {
            //防止重复调用导致缓存永久不过期
            redisTemplates.expire(key, timeout, TimeUnit.SECONDS);
        }

        return count;
    }

}
