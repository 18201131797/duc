package com.security.entity;

import lombok.Data;

/**
 * @version 1.0.0.0
 * @Description:权限用户信息基类
 * @Author: liwt
 * @date: 2019/7/1 14:31
 */

@Data
public class BaseSecurityUserInfo {

    private transient  Integer id;

    private transient  String userName;

    private transient  String password;
}