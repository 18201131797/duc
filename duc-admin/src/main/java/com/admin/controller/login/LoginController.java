package com.admin.controller.login;

import com.admin.source.entity.User;
import com.admin.source.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 9:39
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;
    
    @GetMapping
    public String login(){
        return "login";
    }

}
