package com.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/6/21 16:58
 */
@Data
@ConfigurationProperties(prefix = "jedis")
public class Constant {

    private String prefix = "duc";
}
