package com.web.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version 1.0.0.0
 * @Description: 获取用户信息Controller
 * @Author: liwt
 * @date: 2019/5/29 16:28
 */

public class BaseController {

    @Autowired
    private HttpServletRequest request;

    /**
     * @return
     * @version 1.0.0.0
     * @Description: 获取用户信息
     * @Author: liwt
     */
    public Map<String, Object> getUser() {
        Map<String, Object> user_token = (Map) request.getAttribute("user_token");
        return user_token;
    }
}
