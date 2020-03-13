package com.admin.source.service.user;

import com.admin.source.entity.MsUserInfo;
import com.github.pagehelper.PageInfo;
import com.tkmybatis.base.IBaseService;

/**
 * @version 1.0.0.0
 * @Description: 用户信息
 * @Author: liwt
 * @date: 2019/7/1 10:39
 */

public interface MsUserInfoService extends IBaseService<MsUserInfo> {

    /**
     *@description:分页获取系统用户
     *
     *@param
     *@author liwt
     *@date 2020/3/2 14:35
     *@return
     *@version 1.0.1
     */
    PageInfo pageList(MsUserInfo msUserInfo, Integer page, Integer limit);
}
