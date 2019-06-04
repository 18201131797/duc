package com.redis.base;

/**
 * @version 1.0.0.0
 * @Description: redis缓存基类
 * @Author: liwt
 * @date: 2019/5/30 17:01
 */

public interface ILoadCache<T> {

    /**
     * @param key 缓存主键
     * @description: 用于缓存时效重新加载
     * @author liwt
     * @date 2019年 5月30日 下午5:33:37
     * @version 1.0.0
     */
    T load(String key);
}
