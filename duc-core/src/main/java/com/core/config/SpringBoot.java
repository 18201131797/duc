package com.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: springBoot启动类
 * @Author: liwt
 * @date: 2019/5/24 2:04
 * @version 1.0.0.0
 */
@Slf4j
public class SpringBoot {

    /**
     *@description:springboot启动方法
     *
     *@param
     *@author liwt
     *@date 2019/9/4 11:21
     *@return
     *@version 1.0.1
    */
    public static void run(Class c, String[] args) {
        try {
            ConfigurableApplicationContext content = SpringApplication.run(c, args);
            ConfigurableEnvironment env = content.getEnvironment();
            String protocol = "http";
            if (env.getProperty("server.ssl.key-store") != null) {
                protocol = "https";
            }
            //项目访问路径
            String contextPath = env.getProperty("server.servlet.context-path");
            if(contextPath==null){
                contextPath = "";
            }
            //项目访问端口
            String port = env.getProperty("server.port");

            log.info("\n----------------------------------------------------------\n\t" +
                            "Application '{}' is running! Access URLs:\n\t" +
                            "Local: \t\t{}://localhost:{}{}\n\t" +
                            "External: \t{}://{}:{}{}\n----------------------------------------------------------",
                    env.getProperty("spring.application.name"),
                    protocol,
                    port,
                    contextPath,
                    protocol,
                    InetAddress.getLocalHost().getHostAddress(),
                    port,
                    contextPath
            );
        } catch (UnknownHostException ex) {

        }
    }
}
