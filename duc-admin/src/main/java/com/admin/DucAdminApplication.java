package com.admin;

import com.core.config.SpringBoot;
import com.rocketmq.annotation.EnableMQConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

//@ServletComponentScan("com.web.filter")
@SpringBootApplication
@ComponentScan(basePackages = {"com.admin","com.tkmybatis","com.redis","com.web","com.swagger","com.rocketmq"})
@MapperScan({"com.admin.service.mapper"})
@EnableMQConfiguration
public class DucAdminApplication {

    public static void main(String[] args) {
        SpringBoot.run(DucAdminApplication.class, args);
    }

}
