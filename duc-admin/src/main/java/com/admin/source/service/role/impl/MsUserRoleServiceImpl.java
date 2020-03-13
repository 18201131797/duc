package com.admin.source.service.role.impl;

import com.admin.source.entity.MsUserRole;
import com.admin.source.mapper.MsUserRoleMapper;
import com.admin.source.service.role.MsUserRoleService;
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
public class MsUserRoleServiceImpl extends IBaseServiceImpl<MsUserRole> implements MsUserRoleService {

    @Autowired
    private MsUserRoleMapper msUserRoleMapper;

    @Override
    protected IBaseMapper<MsUserRole> mapper() {
        return msUserRoleMapper;
    }
}
