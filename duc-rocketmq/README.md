  rocketmq:
    name-server-address: xxx.xxx.xxx.xxx;xxx.xxx.xxx
    # 可选, 如果无需发送消息则忽略该配置
    producer-group: local_pufang_producer
    # 发送超时配置毫秒数, 可选, 默认3000
    send-msg-timeout: 5000
    # 追溯消息具体消费情况的开关，默认打开
    trace-enabled: false
    # 是否启用VIP通道，默认打开
    #vip-channel-enabled: false


@MQConsumer(topic = "user-topic", consumerGroup = "local_pufang_producer", tag = "users-tags")
public class DemoConsumer extends AbstractMQPushConsumer {


@MQProducer
public class DemoProducer extends AbstractMQProducer {
