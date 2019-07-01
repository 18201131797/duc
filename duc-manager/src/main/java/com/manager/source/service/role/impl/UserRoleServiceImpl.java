package com.manager.source.service.role.impl;

import com.manager.source.entity.UserRole;
import com.manager.source.mapper.UserRoleMapper;
import com.manager.source.service.role.UserRoleService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 13:00
 */
@Service
public class UserRoleServiceImpl extends IBaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    protected IBaseMapper<UserRole> mapper() {
        return userRoleMapper;
    }
}
