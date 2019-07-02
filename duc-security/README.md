Security 工具包
=========================

**使用方式**

- 集成 UserDetailService<User> User==系统用户

**配置**
```
security:
     matchers[0]: /css/**
     matchers[1]: /fonts/**
     matchers[2]: /images/**
     matchers[3]: /js/**
     matchers[4]: /lib/**
     loginPage: /login
     defaultSuccessUrl: /web/home
     failureUrl: /login?error=false
     logoutUrl: /logout
     logoutSuccessUrl: /login
     secret: MD5
```

|序号    |名称          |说明  |
|:----- |:-----       |:---- |
|0      |security.matchers         |数组：静态资源|
|1      |security.loginPage        |登录页面地址|
|2      |security.defaultSuccessUrl|登录成功跳转地址|
|3      |security.failureUrl       |登录失败跳转地址|
|4      |security.logoutUrl        |登出地址|
|5      |security.logoutSuccessUrl |登出成功跳转地址|
|6      |security.secret           |加密方式：可选，NO不加密，SHA，MD5。默认MD5加密|
