package com.rocketmq.enums;


/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
public enum ConsumeMode {
    /**
     * CONCURRENTLY
     * 使用线程池并发消费
     */
    CONCURRENTLY("CONCURRENTLY"),
    /**
     * ORDERLY
     * 单线程消费
     */
    ORDERLY("ORDERLY");

    private String mode;

    ConsumeMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
