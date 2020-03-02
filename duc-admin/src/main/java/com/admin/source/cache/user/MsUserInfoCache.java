package com.admin.source.cache.user;

import com.admin.source.pojo.entity.MsUserInfo;
import com.admin.source.mapper.MsUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *@description:系统用户缓存
 *
 *@param
 *@author liwt
 *@date 2020/3/2 14:37
 *@return
 *@version 1.0.1
 */
public class MsUserInfoCache {

    @Autowired
    private MsUserInfoMapper msUserInfoMapper;

    public List<MsUserInfo> pageList(MsUserInfo msUserInfo){
        return null;
    }
}
