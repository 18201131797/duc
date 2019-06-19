package com.rocketmq.annotation;

import java.lang.annotation.*;


 /**
 * @version 1.0.0.0
 * @Description: 用来标识作为消息key的字段 prefix 会作为前缀拼到字段值前面
 * @Author: liwt
 * @date: 2019/6/19 11:06
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MQKey {
    String prefix() default "";
}
