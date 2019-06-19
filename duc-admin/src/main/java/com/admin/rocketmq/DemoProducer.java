package com.admin.rocketmq;

import com.admin.service.entity.Student;
import com.rocketmq.annotation.MQProducer;
import com.rocketmq.base.AbstractMQProducer;
import com.rocketmq.base.MessageBuilder;
import org.apache.rocketmq.common.message.Message;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/17 16:07
 */
@MQProducer
public class DemoProducer extends AbstractMQProducer {

    public void send() {

        Message message = MessageBuilder.of(Student.builder().name("你好").id(1).build()).topic("user-topic").tag("users-tags").build();

        super.syncSend(message);
    }
}

