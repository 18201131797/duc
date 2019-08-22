package com.admin.source.service.user.impl;

import com.admin.source.entity.User;
import com.admin.source.mapper.UserMapper;
import com.admin.source.service.user.UserService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 10:39
 */
@Service
public class UserServiceImpl extends IBaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected IBaseMapper<User> mapper() {
        return userMapper;
    }
}
