package com.tkmybatis.base;

/**
 * @description:dto基类
 *
 * @author: liwt
 * @date: 2020/3/2 16:08
 * @version: 1.0.1
 */
public class IBaseDto {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
