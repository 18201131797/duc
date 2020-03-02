package com.admin;

import com.core.config.SpringBoot;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.admin", "com.tkmybatis", "com.security","com.redis"})
@MapperScan({"com.admin.source.mapper"})
public class DucAdminApplication {

    public static void main(String[] args) {
        SpringBoot.run(DucAdminApplication.class, args);
    }

}
