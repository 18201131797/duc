package com.redis.cache;

import com.redis.base.IBaseLaunch;
import com.redis.base.ICacheFactory;
import com.redis.base.ILoadCache;
import com.redis.core.RedisTemplates;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0.0
 * @Description: 针对缓存提供基本的增删改查操作
 * @Author: liwt
 * @date: 2019/5/31 13:26
 */
public class RedisFactory implements ICacheFactory {

    private RedisTemplates redisTemplates;

    private Class clazz;
    private String key;

    public RedisFactory(RedisTemplates redisTemplates, String key, Class clazz) {

        this.redisTemplates = redisTemplates;
        this.key = key;
        this.clazz = clazz;
    }

    public RedisFactory(RedisTemplates redisTemplates, String key) {

        this.redisTemplates = redisTemplates;
        this.key = key;
        this.clazz = clazz;
    }

    /**
     * @version 1.0.0.0
     * @Description: 根据key获取value
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public String get() {
        String value = redisTemplates.get(key);
        if (StringUtils.isNotBlank(value)) {
            //有数据的情况
            return value;
        }
        synchronized (IBaseLaunch.class) {
            value = redisTemplates.get(key);
            if (StringUtils.isNotBlank(value)) {
                //有数据的情况
                return value;
            }
            try {
                if (clazz == null || clazz.getDeclaredMethods() == null) {
                    return null;
                }
                // Redis 开始增量计次：10次。如果10分钟内10次连续查询数据库，则10分钟内返回空
                Long count = increment(key, 10 * 60L);
                if (count >= 10) {
                    return null;
                }
                @SuppressWarnings("unchecked")
                ILoadCache<String> cache = (ILoadCache<String>) clazz.newInstance();
                return cache.load(key);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }

    /**
     * @version 1.0.0.0
     * @Description: 新增缓存过期时间默认一个月
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public void set(String value) {
        redisTemplates.setEx(key, value, 30 * 24 * 60 * 60, TimeUnit.SECONDS);
    }

    /**
     * @version 1.0.0.0
     * @Description: 新增缓存自定义过期时间（秒）
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    public void set(String value, Long timeout) {
        redisTemplates.setEx(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * @version 1.0.0.0
     * @Description: 自增缓存并设置过期时间
     * @Author: liwt
     * @date: 2019/5/31 13:26
     */
    @Override
    public Long increment(String key, Long timeout) {
        key = key + "-count";
        Long count = redisTemplates.incrBy(key, 1);
        if (count < 10) {
            //防止重复调用导致缓存永久不过期
            redisTemplates.expire(key, timeout, TimeUnit.SECONDS);
        }

        return count;
    }
}
