package com.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.core.result.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: liwt
 * @version 1.0.0.0
 * @date: 2020/3/21 0021 11:00
 * @description:登录失败处理类
 * 如果需要扩展直接继承 UserLoginAuthenticationFailureHandler 类
 * 重写 onAuthenticationFailure 方法
 */
@Component
public class UserLoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        String result = JSONObject.toJSONString(Result.resultFail(20001), SerializerFeature.WriteMapNullValue);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }
}
