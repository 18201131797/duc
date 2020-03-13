package com.admin.source.service.menu.impl;

import com.admin.source.entity.MsRoleMenu;
import com.admin.source.mapper.MsRoleMenuMapper;
import com.admin.source.service.menu.MsRoleMenuService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:菜单权限ServiceImpl
 *
 * @author: liwt
 * @date: 2019/9/6 9:41
 * @version: 1.0.1
 */
@Service
public class MsRoleMenuServiceImpl extends IBaseServiceImpl<MsRoleMenu> implements MsRoleMenuService {

    @Autowired
    private MsRoleMenuMapper msRoleMenuMapper;

    @Override
    protected IBaseMapper<MsRoleMenu> mapper() {
        return msRoleMenuMapper;
    }
}
