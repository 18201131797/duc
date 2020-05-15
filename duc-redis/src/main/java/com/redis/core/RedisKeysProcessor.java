package com.redis.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:维护redis ，kyes，用作批量删除
 *
 * @author: liwt
 * @date: 2020/5/15 15:46
 * @version: 1.0.1
 */
@Component
public class RedisKeysProcessor extends RedisConfiguration {

    @Autowired
    private RedisTemplates redisTemplates;
    private final String redisDeleteKeys = "keys";
    private final Long timeOut = 30 * 24 * 60 * 60L;


    /**
     *@description:向缓存种插入某个值，并将改值纪录到set中
     *
     *@param
     *@author liwt
     *@date 2020/5/15 16:19
     *@return
     *@version 1.0.1
     */
    public void setEx(String prefix, String key, Object value, long timeout, TimeUnit unit) {
        redisTemplates.setEx(key, value, timeout, unit);
        String setKey = redisConstant.getPrefix().concat(":").concat(prefix).concat("-").concat(redisDeleteKeys);
        String setValue = key;
        //是否第一次存在改key
        if (!redisTemplates.sIsMember(setKey, setValue)) {
            redisTemplates.sAdd(setKey, setValue);
        }
        //只要有修改就重新设置过期时间
        redisTemplates.expire(setKey, (timeout + timeOut), TimeUnit.SECONDS);
    }

    /**
     *@description:根据key批量删除
     *
     *@param
     *@author liwt
     *@date 2020/5/15 16:20
     *@return
     *@version 1.0.1
     */
    public void deletes(String key) {
        key = key.concat("-").concat(redisDeleteKeys);
        Set<String> keys = redisTemplates.setMembers(key);
        if (null != keys && keys.size() > 0) {
            redisTemplates.delete(keys);
            redisTemplates.delete(key);
        }
    }
}
