package com.redis.aspect;

import com.redis.annotation.CacheClean;
import com.redis.core.RedisSpElProcessor;
import com.redis.core.RedisTemplates;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0.0
 * @Description: redis注解拦截
 * @Author: liwt
 * @date: 2019/6/5 13:33
 */
@Aspect
@Component
@Slf4j
public class RedisCleanAspect extends RedisSpElProcessor {

    @Autowired
    private RedisTemplates redisTemplates;

    @Autowired
    private RedisSpElProcessor redisSpElProcessor;

    @Pointcut("@annotation(com.redis.annotation.CacheClean)")
    public void aspect() {
    }

    @SneakyThrows
    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, CacheClean anno) {
        String[] keys;
        try {
            keys = anno.key();

            if (keys.length < 0) {
                return invocation.proceed();
            }

            for (String key : keys) {
                //计算缓存key
                key = generateSpEL(key, invocation);
                redisTemplates.deleteVague(key);
            }
        } catch (Exception e) {
            log.error("Cache delete failed：", e);
        }
        return invocation.proceed();
    }


}
