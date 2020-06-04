package com.redisson;

import com.google.common.base.Preconditions;
import com.redisson.constant.RedisConnectionType;
import com.redisson.entity.RedissonProperties;
import com.redisson.strategy.RedissonConfigService;
import com.redisson.strategy.impl.ClusterConfigImpl;
import com.redisson.strategy.impl.MasterslaveConfigImpl;
import com.redisson.strategy.impl.SentineConfigImpl;
import com.redisson.strategy.impl.StandaloneConfigImpl;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.config.Config;


/**
 * @description:Redisson核心配置，用于提供初始化的redisson实例
 *
 * @author: liwt
 * @date: 2020/6/4 15:06
 * @version: 1.0.1
 */
@Slf4j
public class RedissonManager {


    private Config config = new Config();

    private Redisson redisson = null;

    private String prefix;

    public RedissonManager() {
    }

    public RedissonManager(RedissonProperties redissonProperties) {
        try {
            //通过不同部署方式获得不同cofig实体
            config = RedissonConfigFactory.getInstance().createConfig(redissonProperties);
            redisson = (Redisson) Redisson.create(config);
            prefix = redissonProperties.getPrefix();
        } catch (Exception e) {
            log.error("Redisson init error", e);
            throw new IllegalArgumentException("please input correct configurations," +
                    "connectionType must in standalone/sentinel/cluster/masterslave");
        }
    }

    public Redisson getRedisson() {
        return redisson;
    }

    public String getPrefix() {
        return prefix;
    }

    /**
     *@description:Redisson连接方式配置工厂
     * 双重检查锁
     *
     *@param
     *@author liwt
     *@date 2020/6/4 15:06
     *@return
     *@version 1.0.1
     */
    static class RedissonConfigFactory {

        private RedissonConfigFactory() {
        }

        private static volatile RedissonConfigFactory factory = null;

        public static RedissonConfigFactory getInstance() {
            if (factory == null) {
                synchronized (Object.class) {
                    if (factory == null) {
                        factory = new RedissonConfigFactory();
                    }
                }
            }
            return factory;
        }


        /**
         *@description:根据连接类型获取对应连接方式的配置,基于策略模式
         *
         *@param
         *@author liwt
         *@date 2020/6/4 15:06
         *@return
         *@version 1.0.1
         */
        Config createConfig(RedissonProperties redissonProperties) {
            Preconditions.checkNotNull(redissonProperties);
            Preconditions.checkNotNull(redissonProperties.getAddress(), "redisson.lock.server.address cannot be NULL!");
            Preconditions.checkNotNull(redissonProperties.getType(), "redisson.lock.server.password cannot be NULL");
            Preconditions.checkNotNull(redissonProperties.getDatabase(), "redisson.lock.server.database cannot be NULL");
            String connectionType = redissonProperties.getType();
            //声明配置上下文
            RedissonConfigService redissonConfigService = null;
            if (connectionType.equals(RedisConnectionType.STANDALONE.getConnection_type())) {
                redissonConfigService = new StandaloneConfigImpl();
            } else if (connectionType.equals(RedisConnectionType.SENTINEL.getConnection_type())) {
                redissonConfigService = new SentineConfigImpl();
            } else if (connectionType.equals(RedisConnectionType.CLUSTER.getConnection_type())) {
                redissonConfigService = new ClusterConfigImpl();
            } else if (connectionType.equals(RedisConnectionType.MASTERSLAVE.getConnection_type())) {
                redissonConfigService = new MasterslaveConfigImpl();
            } else {
                throw new IllegalArgumentException("创建Redisson连接Config失败！当前连接方式:" + connectionType);
            }
            return redissonConfigService.createRedissonConfig(redissonProperties);
        }
    }

}


