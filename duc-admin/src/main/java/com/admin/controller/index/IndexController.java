package com.admin.controller.index;

import com.admin.controller.base.BaseController;
import com.security.base.UserSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        UserSecurity user = findUser();
        return "welcome";
    }
}
