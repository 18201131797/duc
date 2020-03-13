package com.admin.source.cache.user;

import com.admin.source.entity.MsUserInfo;
import com.admin.source.mapper.MsUserInfoMapper;
import com.redis.annotation.Cacheable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:系统用户缓存
 *
 * @author: liwt
 * @date: 2020/3/3 9:31
 * @version: 1.0.1
 */
@Component
public class MsUserInfoCache {

    @Autowired
    private MsUserInfoMapper msUserInfoMapper;

    /**
     *@description:根据实体查询数据
     *
     *@param
     *@author liwt
     *@date 2020/3/3 9:34
     *@return
     *@version 1.0.1
     */
    @Cacheable(key = "MsUserInfoCache.select")
    public List<MsUserInfo> select(MsUserInfo msUserInfo) {
        List<MsUserInfo> result = msUserInfoMapper.selectByExample(establish(msUserInfo));
        return result;
    }

    /**
     *@description:创建example
     *
     *@param
     *@author liwt
     *@date 2020/3/3 12:29
     *@return
     *@version 1.0.1
     */
    public Example establish(MsUserInfo msUserInfo) {
        Example example = new Example(msUserInfo.getClass());
        example.setOrderByClause("create_time desc");
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(msUserInfo.getUserName())) {
            criteria.andLike("userName", "%".concat(msUserInfo.getUserName()).concat("%"));
        }
        return example;
    }
}
