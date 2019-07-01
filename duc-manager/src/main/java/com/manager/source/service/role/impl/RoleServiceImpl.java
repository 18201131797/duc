package com.manager.source.service.role.impl;

import com.manager.source.entity.Role;
import com.manager.source.mapper.RoleMapper;
import com.manager.source.service.role.RoleService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 12:57
 */
@Service
public class RoleServiceImpl extends IBaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected IBaseMapper<Role> mapper() {
        return roleMapper;
    }
}
