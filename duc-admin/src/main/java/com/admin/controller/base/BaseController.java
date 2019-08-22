package com.admin.controller.base;

import com.security.base.UserSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/2 11:22
 */

public class BaseController {

    /**
     * 获取登陆用户信息
     * @return
     */
    public UserSecurity findUser() {
        UserSecurity userSecurity = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userSecurity;
    }
}
