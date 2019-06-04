package com.web.spring;

/**
 * @version 1.0.0.0
 * @Description: 从上下文中加载
 * @Author: liwt
 * @date: 2019/6/2 10:10
 */

public class SpringLoad {
    public static <T> T getInstance(Class<T> clazz) {
        return SpringCtxUtil.getBean(clazz);
    }
}
