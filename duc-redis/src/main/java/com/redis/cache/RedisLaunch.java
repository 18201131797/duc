package com.redis.cache;

import com.redis.base.IBaseLaunch;
import com.redis.base.ICacheFactory;
import com.redis.core.RedisTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0.0
 * @Description: redis核心工具类，供外部调用。
 * @Author: liwt
 * @date: 2019/5/31 14:34
 */
@Component
public class RedisLaunch implements IBaseLaunch<ICacheFactory> {

    @Autowired
    private RedisTemplates redisTemplates;

    @Override
    public ICacheFactory loadServiceCache(String key, Class clazz) {
        return new RedisFactory(redisTemplates,key,clazz);
    }

    @Override
    public ICacheFactory loadServiceCache(String key) {
        return new RedisFactory(redisTemplates,key);
    }
}
