package com.rocketmq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @version 1.0.0.0
 * @Description: RocketMQ生产者自动装配注解
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MQProducer {
}
