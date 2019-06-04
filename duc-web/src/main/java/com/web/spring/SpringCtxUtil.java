package com.web.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @version 1.0.0.0
 * @Description: 上下文环境
 * @Author: liwt
 * @date: 2019/6/2 10:07
 */

public class SpringCtxUtil {


    private static ApplicationContext ctx;

    private SpringCtxUtil() {
    }

    public static void setApplicationContext(ApplicationContext ctx) {
        SpringCtxUtil.ctx = ctx;
    }

    public static ApplicationContext getContext() {
        return ctx;
    }

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return (T) ctx.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) throws BeansException {
        return (T) ctx.getBean(beanName);
    }
}
