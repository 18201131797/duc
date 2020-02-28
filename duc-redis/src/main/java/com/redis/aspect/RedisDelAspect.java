package com.redis.aspect;

import com.redis.annotation.CacheClean;
import com.redis.core.AspectCore;
import com.redis.core.RedisConfiguration;
import com.redis.core.RedisTemplates;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0.0
 * @Description: redis注解拦截
 * @Author: liwt
 * @date: 2019/6/5 13:33
 */
@Aspect
@Component
@Slf4j
public class RedisDelAspect extends RedisConfiguration {

    @Autowired
    private RedisTemplates redisTemplates;

    @Autowired
    private AspectCore aspectCore;

    @Pointcut("@annotation(com.redis.annotation.CacheClean)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, CacheClean anno) {
        Object result = null;
        String key;
        List<String> keys;
        try {
            key = anno.key();
            keys = Arrays.asList(anno.keys());
            if (StringUtils.isNotBlank(key)) {
                keys = new ArrayList<>();
                keys.add(key);
            }

            if (keys.size() == 0) {
                //key 必填
                return result;
            }
            if (keys.size() > 0) {
                for (String item : keys) {
                    redisTemplates.deleteVague(aspectCore.baptismKey(invocation, item));
                }
            }
        } catch (Exception e) {
            log.error("缓存删除失败：", e);
        } finally {

        }
        return result;
    }


}
