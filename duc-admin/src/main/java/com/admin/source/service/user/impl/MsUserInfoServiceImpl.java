package com.admin.source.service.user.impl;

import com.admin.source.entity.MsUserInfo;
import com.admin.source.mapper.MsUserInfoMapper;
import com.admin.source.service.user.MsUserInfoService;
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
public class MsUserInfoServiceImpl extends IBaseServiceImpl<MsUserInfo> implements MsUserInfoService {

    @Autowired
    private MsUserInfoMapper msUserInfoMapper;

    @Override
    protected IBaseMapper<MsUserInfo> mapper() {
        return msUserInfoMapper;
    }
}
