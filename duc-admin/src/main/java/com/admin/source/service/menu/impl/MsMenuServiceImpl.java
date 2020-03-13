package com.admin.source.service.menu.impl;

import com.admin.source.entity.MsMenu;
import com.admin.source.mapper.MsMenuMapper;
import com.admin.source.service.menu.MsMenuService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:菜单ServiceImpl
 *
 * @author: liwt
 * @date: 2019/9/6 9:41
 * @version: 1.0.1
 */
@Service
public class MsMenuServiceImpl extends IBaseServiceImpl<MsMenu> implements MsMenuService {

    @Autowired
    private MsMenuMapper msMenuMapper;

    @Override
    protected IBaseMapper<MsMenu> mapper() {
        return msMenuMapper;
    }
}
