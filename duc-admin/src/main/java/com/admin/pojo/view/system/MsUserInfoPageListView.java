package com.admin.pojo.view.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *@description:系统用户分页
 *
 *@param
 *@author liwt
 *@date 2020/3/3 13:56
 *@return
 *@version 1.0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsUserInfoPageListView {


    /**
     * 管理系统用户信息表id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 启用状态；1启用 2停用
     */
    private Integer flag;

    /**
     * 性别 1：男 2：女
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 角色名称
     */
    private String roleName;
}
