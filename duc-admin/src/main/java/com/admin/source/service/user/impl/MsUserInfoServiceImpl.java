package com.admin.source.service.user.impl;

import com.admin.source.entity.MsUserInfo;
import com.admin.source.mapper.MsUserInfoMapper;
import com.admin.source.service.user.MsUserInfoService;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/7/1 10:39
 */
@Service
public class MsUserInfoServiceImpl extends IBaseServiceImpl<MsUserInfo> implements MsUserInfoService {

    @Autowired
    private MsUserInfoMapper msUserInfoMapper;

    @Override
    protected IBaseMapper<MsUserInfo> mapper() {
        return msUserInfoMapper;
    }

    /**
     *@description:获取系统用户分页
     *
     *@param
     *@author liwt
     *@date 2020/3/2 14:35
     *@return
     *@version 1.0.1
     */
    @Override
    public List<MsUserInfo> pageList() {
        return null;
    }
}
