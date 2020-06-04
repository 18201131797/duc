使用方式： 

非注解
@Autowired
RedissonLock redissonLock;
redissonLock.lock("lock", 100L);
redissonLock.unlock("lock");


注解
@DistributedLock(value="lock", leaseTime=5)

前缀配置
redisson.prefix: xxx

yml配置
########################################################################
#
#     redisson单机配置
#
#########################################################################
spring:
  redisson:
    prefix: duc
    address: 127.0.0.1:6379
    type: standalone
    password:
    database: 1
########################################################################
#
#     redisson哨兵配置
#     **redisson.lock.server.address** 格式为: sentinel.conf配置里的sentinel别名,
#     sentinel1节点的服务IP和端口，sentinel2节点的服务IP和端口，sentinel3节点的服务IP和端口
#
#     比如sentinel.conf里配置为sentinel monitor my-sentinel-name 127.0.0.1 6379 2,那么这里就配置my-sentinel-name
#
#########################################################################
spring:
  redisson:
    prefix: duc
    address: my-sentinel-name,127.0.0.1:26379,127.0.0.1:26389,127.0.0.1:26399
    type: sentinel
    password:
    database: 1
########################################################################
#
#     redisson分布式锁配置--集群方式
#     cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
#     地址格式为: 127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381,127.0.0.1:6382,127.0.0.1:6383,127.0.0.1:6384
#########################################################################

spring:
  redisson:
    prefix: duc
    address: 127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381,127.0.0.1:6382,127.0.0.1:6383,127.0.0.1:6384
    type: cluster
    password:
########################################################################
#
#     redisson分布式锁配置--主从
#     地址格式为**主节点,子节点,子节点**
#     代表主节点:127.0.0.1:6379，从节点127.0.0.1:6380，127.0.0.1:6381

#########################################################################
spring:
  redisson:
    prefix: duc
    address: 127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381
    type: masterslave
    password:
    database: 1