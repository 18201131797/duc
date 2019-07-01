package com.manager;

import com.core.config.SpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.manager.source.mapper"})
@ComponentScan(basePackages = {"com.tkmybatis","com.manager"})
@SpringBootApplication
public class DucManagerApplication {

	public static void main(String[] args) {
		SpringBoot.run(DucManagerApplication.class,args);
	}

}
