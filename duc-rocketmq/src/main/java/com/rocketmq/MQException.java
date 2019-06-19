package com.rocketmq;

/**
 * @version 1.0.0.0
 * @Description: RocketMQ的自定义异常
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
public class MQException extends RuntimeException {
    public MQException(String msg) {
        super(msg);
    }
}
