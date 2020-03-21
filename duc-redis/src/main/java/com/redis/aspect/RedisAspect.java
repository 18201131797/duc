package com.redis.aspect;

import com.alibaba.fastjson.JSONObject;
import com.redis.annotation.Cacheable;
import com.redis.core.RedisSpElProcessor;
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
public class RedisAspect extends RedisSpElProcessor {

    private final int retryCount = 10;

    @Autowired
    private RedisTemplates redisTemplates;


    @Pointcut("@annotation(com.redis.annotation.Cacheable)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, Cacheable anno) {

        MethodSignature signature = (MethodSignature) invocation.getSignature();

        Method method = signature.getMethod();
        Object result = null;
        String value;
        String key = anno.spelKey();
        try {
            //计算缓存key
            key = generateSpEL(anno.key(), key, invocation);
            value = redisTemplates.get(key);
            Type returnType = method.getGenericReturnType();
            result = getResult(value, returnType);
            if (result == null) {
                result = getValue(key, invocation);
                if (StringUtils.isNotBlank(key) && result != null) {
                    redisTemplates.setEx(key, result, anno.timeout(), TimeUnit.SECONDS);
                }
            }
        } catch (Exception e) {
            log.error("Cache get failed：" + key, e);
        }
        return result;
    }


    /**
     * @version 1.0.0.0
     * @Description: 获取 value 防止缓存穿透
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public Object getValue(String key, ProceedingJoinPoint invocation) {
        Object result = null;
        try {
            // Cacheable 开始增量计次：10次。如果10分钟内10次连续查询数据库，则10分钟内返回空
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


    public Object getResult(String value, Type returnType) {
        Object result = JSONObject.parseObject(value,returnType);
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
