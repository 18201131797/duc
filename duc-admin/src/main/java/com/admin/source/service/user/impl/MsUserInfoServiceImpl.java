package com.admin.source.service.user.impl;

import com.admin.enums.EDelete;
import com.admin.enums.EEnable;
import com.admin.pojo.view.system.MsUserInfoPageListView;
import com.admin.source.cache.role.MsRoleCache;
import com.admin.source.cache.user.MsUserInfoCache;
import com.admin.source.entity.MsRole;
import com.admin.source.entity.MsUserInfo;
import com.admin.source.mapper.MsUserInfoMapper;
import com.admin.source.service.user.MsUserInfoService;
import com.core.model.ModelUtil;
import com.github.pagehelper.PageInfo;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import com.tkmybatis.page.PageHelper;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private MsRoleCache msRoleCache;

    @Autowired
    private MsUserInfoCache msUserInfoCache;

    @Override
    protected IBaseMapper<MsUserInfo> mapper() {
        return msUserInfoMapper;
    }


    /**
     *@description:分页
     *
     *@param
     *@author liwt
     *@date 2020/3/3 9:36
     *@return
     *@version 1.0.1
     */
    @Override
    public PageInfo pageList(MsUserInfo msUserInfo, Integer page, Integer limit) {
        msUserInfo.setFlag(EEnable.TRUE.getCode());
        msUserInfo.setDeleteFlag(EDelete.NODELETE.getCode());

        MsUserInfoPageListView msUserInfoPageListView = ModelUtil.modelToModel(msUserInfo, MsUserInfoPageListView.class);
        msUserInfoPageListView.setPageNum(page);
        msUserInfoPageListView.setPageSize(limit);
        PageInfo<?> condition = new PageHelper(msUserInfoPageListView).condition(() -> {

            List<MsUserInfo> msUserInfos = selectByExample(msUserInfoCache.establish(msUserInfo));
            List<MsUserInfoPageListView> msUserInfoPageListViews = ModelUtil.modelToModel(msUserInfos, MsUserInfoPageListView.class);
            for (MsUserInfoPageListView item : msUserInfoPageListViews) {
                List<MsRole> msRoles = msRoleCache.getRoleByUserId(item.getId());
                StringBuffer roleName = new StringBuffer();
                msRoles.stream().forEach(m -> roleName.append(m.getRoleName().concat(",")));
                if (StringUtils.isBlank(roleName)) {
                    continue;
                }
                item.setRoleName(roleName.deleteCharAt(roleName.length() - 1).toString());
            }
            return msUserInfos;
        });

        return condition;
    }
}
