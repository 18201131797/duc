package com.redis.aspect;

import com.redis.annotation.RedisDel;
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

/**
 * @version 1.0.0.0
 * @Description: redis注解拦截
 * @Author: liwt
 * @date: 2019/6/5 13:33
 */
@Aspect
@Component
@Slf4j
public class RedisDelAspect {

    @Autowired
    private RedisTemplates redisTemplates;

    @Pointcut("@annotation(com.redis.annotation.RedisDel)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(RedisDel anno) {
        Object result = null;
        try {
            if (StringUtils.isNotBlank(anno.key())) {
                redisTemplates.delete(anno.key());
            } else if (anno.keys().length > 0) {
                for (String key : anno.keys()) {
                    redisTemplates.delete(key);
                }
            }
        } catch (Exception e) {
            log.error("缓存删除失败：", e);
        } finally {

        }
        return result;
    }
}
