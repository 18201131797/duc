package com.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0.0.0
 * @Description: redis注解类
 * @Author: liwt
 * @date: 2019/6/5 13:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface Redis {

    /**
     * @version 1.0.0.0
     * @Description: redis key
     * @Author: liwt
     * @date: 2019/6/5 13:32
     */
    String key() default "";

    /**
     * @version 1.0.0.0
     * @Description: redis 过期时间（秒） 默认一个月
     * @Author: liwt
     * @date: 2019/6/5 13:32
     */
    long timeout() default 30 * 24 * 60 * 60;

}
