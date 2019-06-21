package com.redis.core;

import com.redis.config.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/21 17:17
 */

@EnableConfigurationProperties(Constant.class)
public class RedisConfiguration {

    @Autowired
    public Constant redisConstant;
}
