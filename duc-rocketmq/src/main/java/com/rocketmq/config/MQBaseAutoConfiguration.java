package com.rocketmq.config;

import com.rocketmq.annotation.EnableMQConfiguration;
import com.rocketmq.base.AbstractMQProducer;
import com.rocketmq.base.AbstractMQPushConsumer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0.0
 * @Description: RocketMQ配置文件
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
@Configuration
@ConditionalOnBean(annotation = EnableMQConfiguration.class)
@AutoConfigureAfter({AbstractMQProducer.class, AbstractMQPushConsumer.class})
@EnableConfigurationProperties(MQProperties.class)
public class MQBaseAutoConfiguration implements ApplicationContextAware {
    protected MQProperties mqProperties;

    @Autowired
    public void setMqProperties(MQProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    protected ConfigurableApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

}

