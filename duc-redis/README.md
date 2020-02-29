使用方式： 
key使用 spel表达式
@Cacheable(key = "xxx#id")
@CacheClean(key = "xxx**")

默认使用 类名全路径+方法名当做key(Redis和RedisClean同样)


前缀配置
redis.prefix: xxx

yml配置
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    password:
    jedis:
      pool:
        max-active: 100
        max-idle: 10