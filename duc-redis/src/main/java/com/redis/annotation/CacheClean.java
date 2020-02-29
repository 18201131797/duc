package com.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0.0.0
 * @Description: redis注解类[删除缓存]
 * @Author: liwt
 * @date: 2019/6/5 13:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface CacheClean {

    /**
     * @version 1.0.0.0
     * @Description: 缓存集合
     * @Author: liwt
     * @date: 2019/6/5 13:32
     */
    String[] key() default {};

}
