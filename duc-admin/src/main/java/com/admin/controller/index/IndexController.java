package com.admin.controller.index;

import com.admin.controller.base.BaseController;
import com.admin.source.cache.role.MsRoleCache;
import com.security.base.UserSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/2 11:24
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    @Resource
    private MsRoleCache msRoleCache;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {

        msRoleCache.test1("1");
        msRoleCache.test1("2");
        msRoleCache.test1("3");
        msRoleCache.test3("643");
        msRoleCache.test3("646");
        msRoleCache.test2();

        UserSecurity user = findUser();
        return "welcome";
    }
}
