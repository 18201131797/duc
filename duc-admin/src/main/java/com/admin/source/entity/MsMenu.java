package com.admin.source.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ms_menu")
public class MsMenu {
    /**
     * 目录表id
     */
    @Id
    private Integer id;

    /**
     * 目录名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 排序
     */
    @Column(name = "menu_sort")
    private Integer menuSort;

    /**
     * 菜单地址
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

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