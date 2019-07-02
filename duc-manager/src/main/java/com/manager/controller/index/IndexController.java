package com.manager.controller.index;

import com.manager.controller.base.BaseController;
import com.security.base.UserSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/2 11:24
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    @GetMapping
    @ResponseBody
    public UserSecurity index() {
        UserSecurity user = findUser();
        return user;
    }
}
