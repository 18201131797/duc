package com.admin.source.service.role.impl;

import com.admin.source.entity.MsRole;
import com.admin.source.mapper.MsRoleMapper;
import com.admin.source.service.role.MsRoleService;
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
public class MsRoleServiceImpl extends IBaseServiceImpl<MsRole> implements MsRoleService {

    @Autowired
    private MsRoleMapper msRoleMapper;

    @Override
    protected IBaseMapper<MsRole> mapper() {
        return msRoleMapper;
    }
}
