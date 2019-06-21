package com.redis.aspect;

import com.redis.annotation.CacheClean;
import com.redis.core.RedisConfiguration;
import com.redis.core.RedisTemplates;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class RedisDelAspect extends RedisConfiguration {

    @Autowired
    private RedisTemplates redisTemplates;


    @Pointcut("@annotation(com.redis.annotation.CacheClean)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(CacheClean anno) {
        Object result = null;
        String key;
        try {
            key = anno.key();
            if ("".equals(key)) {
                //key 必填
                return result;
            }
            //添加前缀
            key = redisConstant.getPrefix().concat(":").concat(key);
            if (StringUtils.isNotBlank(key)) {
                redisTemplates.delete(key);
            } else if (anno.keys().length > 0) {
                for (String item : anno.keys()) {
                    redisTemplates.delete(item);
                }
            }
        } catch (Exception e) {
            log.error("缓存删除失败：", e);
        } finally {

        }
        return result;
    }
}
