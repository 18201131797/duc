package com.rocketmq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @version 1.0.0.0
 * @Description: RocketMQ事务消息生产者
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MQTransactionProducer {

    /**
     * *重要* 事务的反查是基于同一个producerGroup为维度
     */
    String producerGroup();
}
