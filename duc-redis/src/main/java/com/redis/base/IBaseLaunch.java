package com.redis.base;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/31 14:27
 */

public interface IBaseLaunch<T> {
    T loadServiceCache(String key, Class clazz);
    T loadServiceCache(String key);
}
