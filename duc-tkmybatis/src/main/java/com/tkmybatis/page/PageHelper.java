package com.tkmybatis.page;

import com.github.pagehelper.PageInfo;
import com.tkmybatis.base.IBaseDto;

import java.util.List;

public class PageHelper {

    //分页数据
    private IBaseDto dto;

    //排序方式
    private String orderBy;

    //排序字段
    private String field;

    /**
     *@description:初始化分页信息
     *
     *@param
     *@author liwt
     *@date 2019/7/24 20:02
     *@return
     *@version 1.0.1
     */
    public PageHelper(IBaseDto dto) {
        this.dto = dto;
        int pageNum = dto.getPageNum();
        int pageSize = dto.getPageSize();
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize);
    }

    /**
     *@description:初始化分页信息
     *
     *@param
     *@author liwt
     *@date 2020/6/4 13:43
     *@return
     *@version 1.0.1
     */
    public PageHelper(IBaseDto dto, String field, String orderBy) {
        this.dto = dto;
        this.orderBy = orderBy;
        this.field = field;
        int pageNum = dto.getPageNum();
        int pageSize = dto.getPageSize();
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize, field.concat(" ") + orderBy);
    }

    /**
     *@description:分页信息
     *
     *@param
     *@author liwt
     *@date 2019/7/23 16:14
     *@return
     *@version 1.0.1
     * 调用实例
     * RpcResult<?> result = new PageUtilsHelper(dto, "desc").page(myFileService.pageList(dto));
     */
    public <T> PageInfo<T> page(List<T> t) {
        return new PageInfo<T>(t);
    }


    /**
     *@description:修改查询结果
     *
     *@param
     *@author liwt
     *@date 2020/5/7 15:27
     *@return
     *@version 1.0.1
     * 调用实例
     * new PageUtil(dto, "update_time", "desc").condition(() -> {
     *             List<AppExclusionRule> appExclusionRules = appExclusionRuleMapper.selectByDto(dto);
     *             for(AppExclusionRule item : appExclusionRules){
     *                 item.setId("1000000");
     *             }
     *             return appExclusionRules;
     *         });
     */
    public <T> PageInfo<?> condition(PageHelperCondition<T> t) {
        return new PageInfo<T>(t.condition());
    }
}
