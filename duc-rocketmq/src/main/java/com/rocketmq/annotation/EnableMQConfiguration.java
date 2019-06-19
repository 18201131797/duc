package com.rocketmq.annotation;

import java.lang.annotation.*;

/**
 * @version 1.0.0.0
 * @Description: rocketmq注解类
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableMQConfiguration {
}
