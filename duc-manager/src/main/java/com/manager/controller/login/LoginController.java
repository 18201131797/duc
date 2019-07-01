package com.manager.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 9:39
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "login";
    }
}
