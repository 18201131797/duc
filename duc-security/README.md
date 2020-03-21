Security 工具包
=========================

**使用方式**

- 1.继承 (User == 系统用户)
```
     extends UserDetailService<User>
```

- 2.(系统用户)继承 
```
     extends BaseSecurityEntity
```

**配置**
```
security:
     matchers[0]: /css/**
     matchers[1]: /fonts/**
     matchers[2]: /images/**
     matchers[3]: /js/**
     matchers[4]: /lib/**
     loginPage: /login
     logoutUrl: /logout
     logoutSuccessUrl: /login
     secret: MD5
```

|序号   |名称                      |说明  |
|:----- |:-----                    |:---- |
|0      |security.matchers         |数组：静态资源|
|1      |security.loginPage        |登录页面地址|
|2      |security.logoutUrl        |登出地址|
|3      |security.logoutSuccessUrl |登出成功跳转地址|
|4      |security.secret           |加密方式：可选，NO不加密，SHA，MD5。默认MD5加密|

**注**

- User == 系统用户 必须要有 

```
    private String username;

    private String password;
```

两个属性  和get set方法
