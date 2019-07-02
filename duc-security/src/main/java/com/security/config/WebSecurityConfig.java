package com.security.config;

import com.security.base.UserDetailService;
import com.security.common.MD5PasswordEncoder;
import com.security.common.NOPasswordEncoder;
import com.security.common.SHAPasswordEncoder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Configuration
@EnableWebSecurity
@ConfigurationProperties("security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailService userDetailService;

    //静态资源
    private String[] matchers;
    //登录地址
    private String loginPage;
    //登录成功跳转地址
    private String defaultSuccessUrl;
    //登录失败跳转地址
    private String failureUrl;
    //登出地址
    private String logoutUrl;
    //登出成功跳转地址
    private String logoutSuccessUrl;
    //加密方式：NO不加密，MD5,SHA。默认MD5
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception { http
                .authorizeRequests()
                //静态资源
                .antMatchers(matchers).permitAll()
                .anyRequest().authenticated() //4
                .and()
                .formLogin()
                .loginPage(loginPage)
                .defaultSuccessUrl(defaultSuccessUrl)
                .failureUrl(failureUrl)
                .permitAll() //登陆页面可任意访问
                .and()
                .logout()
                .logoutUrl(logoutUrl)//自定义退出的地址
                .logoutSuccessUrl(logoutSuccessUrl)//退出之后跳转到注册页面

        ;

        http.headers().frameOptions().disable();
        // 关闭CSRF跨域
        http.csrf().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
        auth.eraseCredentials(false);
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new MD5PasswordEncoder();
        if ("false".equals(secret)) {
            passwordEncoder = new NOPasswordEncoder();
        } else if ("SHA".equals(secret)) {
            passwordEncoder = new SHAPasswordEncoder();
        }
        return passwordEncoder;
    }
}

