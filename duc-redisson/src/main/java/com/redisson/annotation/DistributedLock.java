package com.redisson.annotation;

import java.lang.annotation.*;

/**
 * @description:基于注解的分布式式锁
 *
 * @author: liwt
 * @date: 2020/6/4 15:03
 * @version: 1.0.1
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributedLock {

    /**
     * 锁的名称
     */
    String value() default "redisson";

    /**
     * 锁的有效时间
     */
    int leaseTime() default 10;
}


