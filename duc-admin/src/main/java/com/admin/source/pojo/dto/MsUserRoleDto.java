package com.admin.source.pojo.dto;

import com.tkmybatis.base.IBaseDto;
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
@Table(name = "ms_user_role")
public class MsUserRoleDto extends IBaseDto implements Serializable {

    private static final long serialVersionUID = 8299044420050704583L;

    /**
     * 用户角色表id
     */
    @Id
    private Integer id;

    /**
     * ms_user_info 表 主键
     */
    @Column(name = "ms_user_id")
    private Integer msUserId;

    /**
     * ms_role表主键
     */
    @Column(name = "ms_role_id")
    private Integer msRoleId;

    /**
     * 备注
     */
    private String remark;

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
}