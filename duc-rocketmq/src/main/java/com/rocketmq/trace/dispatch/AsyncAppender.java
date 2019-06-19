package com.rocketmq.trace.dispatch;

/**
 * @version 1.0.0.0
 * @Description: 数据编码和发送模块
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
public abstract class AsyncAppender {
    /**
     *编码数据上下文到缓冲区
     * @param context 上下文
     */
    public abstract void append(Object context);

    /**
     * 实际写数据操作
     */
    public abstract void flush();
}
