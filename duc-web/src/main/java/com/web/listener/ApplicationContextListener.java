package com.web.listener;

import com.web.spring.SpringCtxUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0.0
 * @Description: 获取上下文
 * @Author: liwt
 * @date: 2019/6/2 10:05
 */
@Component
public class ApplicationContextListener implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringCtxUtil.setApplicationContext(applicationContext);
    }
}
