package com.admin.rocketmq;

import com.rocketmq.annotation.MQConsumer;
import com.rocketmq.base.AbstractMQPushConsumer;

import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/17 16:08
 */
@MQConsumer(topic = "user-topic", consumerGroup = "local_pufang_producer", tag = "users-tags")
public class DemoConsumer extends AbstractMQPushConsumer {

    @Override
    public boolean process(Object message, Map extMap) {
        System.out.println(message);
        return true;
    }
}
