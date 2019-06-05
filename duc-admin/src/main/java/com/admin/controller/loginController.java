package com.admin.controller;

import com.redis.annotation.RedisDel;
import com.web.jwt.Jwt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/29 15:53
 */

@RestController
@RequestMapping("/login")
public class loginController {


    @RedisDel(key = "student")
    @GetMapping
    public String index() {
        Map<String, Object> map = new HashMap() {{
            put("name", "liwt");
            put("password", "admin");
            put("date", new Date().getTime());
        }};
        return Jwt.createToken(map);
    }
}
