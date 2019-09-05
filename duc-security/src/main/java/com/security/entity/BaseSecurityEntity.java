package com.security.entity;

import lombok.Data;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 14:31
 */

@Data
public class BaseSecurityEntity {

    private Integer id;

    private String userName;

    private String password;
}