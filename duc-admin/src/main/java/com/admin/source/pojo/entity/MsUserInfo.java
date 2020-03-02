package com.admin.source.pojo.entity;

import com.security.entity.BaseSecurityUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ms_user_info")
public class MsUserInfo extends BaseSecurityUserInfo implements Serializable {

    private static final long serialVersionUID = -205538722568919532L;

    /**
     * 管理系统用户信息表id
     */
    @Id
    private Integer id;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 员工编号
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 平台标识码
     */
    private String platform;

    /**
     * 启用状态；1启用 2停用
     */
    private Integer flag;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 性别 1：男 2：女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 用户头像
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 后台页面css样式
     */
    @Column(name = "page_css")
    private String pageCss;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建人姓名
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private Integer updateUserId;

    /**
     * 更新者姓名
     */
    @Column(name = "update_user_name")
    private String updateUserName;

    /**
     * 删除标记: 0删除|1未删除
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 备注
     */
    private String remark;


}