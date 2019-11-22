使用方式：
@Cacheable(key = "xxx")
@CacheClean(key = "xxx")

默认使用 类名全路径+方法名当做key(Redis和RedisDel同样)


前缀配置
redis.prefix: xxx