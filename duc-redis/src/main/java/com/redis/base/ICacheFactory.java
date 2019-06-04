package com.redis.base;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/31 14:29
 */

public interface ICacheFactory {


    /**
     * @version 1.0.0.0
     * @Description: 根据key获取value
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    String get();


    /**
     * @version 1.0.0.0
     * @Description: 新增缓存过期时间默认一个月
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    void set(String value);


    /**
     * @version 1.0.0.0
     * @Description: 新增缓存自定义过期时间（秒）
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    void set(String value, Long timeout);

    /**
     * @version 1.0.0.0
     * @Description: 自增缓存并设置过期时间
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    Long increment(String key,Long timeout);
}
