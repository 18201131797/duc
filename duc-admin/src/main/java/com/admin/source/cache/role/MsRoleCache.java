package com.admin.source.cache.role;

import com.admin.enums.EDelete;
import com.admin.source.entity.MsRole;
import com.admin.source.entity.MsUserRole;
import com.admin.source.mapper.MsRoleMapper;
import com.admin.source.mapper.MsUserRoleMapper;
import com.redis.annotation.CacheClean;
import com.redis.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:用户角色缓存
 *
 * @author: liwt
 * @date: 2020/3/3 14:20
 * @version: 1.0.1
 */
@Component
public class MsRoleCache {

    @Autowired
    private MsUserRoleMapper msUserRoleMapper;

    @Autowired
    private MsRoleMapper msRoleMapper;

    @Cacheable(key = "teeeeeecc-123",spelKey = "#id")
    public String test1(String id){
        return "cdteeeeeecc";
    }
    @CacheClean(key = {"teeeeeecc-123","teeeeeecc-568"})
    public void test2(){}


    @Cacheable(key = "teeeeeecc-568",spelKey = "#id")
    public String test3(String id){
        return "cdteeeeeecc";
    }

    /**
     *@description:根据用户id获取用火角色
     *
     *@param
     *@author liwt
     *@date 2020/3/3 14:26
     *@return
     *@version 1.0.1
     */
    @Cacheable(key = "MsRoleCache:getRoleByUserId", spelKey = "#userId")
    public List<MsRole> getRoleByUserId(Integer userId) {
        List<MsRole> result = new ArrayList<>();
        List<MsUserRole> msUserRole = msUserRoleMapper.select(MsUserRole.builder().msUserId(userId).deleteFlag(EDelete.NODELETE.getCode()).build());
        for (MsUserRole item : msUserRole) {
            MsRole msRole = msRoleMapper.selectByPrimaryKey(item.getMsRoleId());
            result.add(msRole);
        }
        return result;
    }
}
