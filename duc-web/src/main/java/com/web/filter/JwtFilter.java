package com.web.filter;

import com.alibaba.fastjson.JSONObject;
import com.core.result.Result;
import com.web.jwt.Jwt;
import com.web.jwt.TokenState;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @version 1.0.0.0
 * @Description: jwt过滤器
 * @Author: liwt
 * @date: 2019/5/29 15:27
 */
@WebFilter(urlPatterns = "/*")
public class JwtFilter implements Filter {

    //允许通过的url
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login")));


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        if (allowedPath) {
            filterChain.doFilter(request, response);
        }
        //其他API接口一律校验token
        System.out.println("开始校验token");
        //从请求头中获取token
        String token = request.getHeader("token");
        Map<String, Object> resultMap = Jwt.validToken(token);
        TokenState state = TokenState.getTokenState((String) resultMap.get("state"));
        switch (state) {
            case VALID:
                //取出payload中数据,放入到request作用域中
                //todo 目前只适合单机，暂不支持分布
                request.setAttribute("user_token", resultMap.get("data"));
                //放行
                filterChain.doFilter(request, response);
                break;
            case EXPIRED:
            case INVALID:
                System.out.println("无效token");
                //token过期或者无效，则输出错误信息返回给ajaxR

                String result = JSONObject.toJSONString(Result.result(false, 10000));
                output(result, response);
                break;
        }

    }

    public void output(String result, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();

    }
}
