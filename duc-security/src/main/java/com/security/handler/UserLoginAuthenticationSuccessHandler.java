package com.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.core.result.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: liwt
 * @version 1.0.0.0
 * @date: 2020/3/21 0021 11:00
 * @description:登录成功处理类
 *  * 如果需要扩展直接继承 UserLoginAuthenticationSuccessHandler 类
 *  * 重写 onAuthenticationFailure 方法
 */
@Component
public class UserLoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String result = JSONObject.toJSONString(Result.resultSuccess(20000), SerializerFeature.WriteMapNullValue);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }
}
