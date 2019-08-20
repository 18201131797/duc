package com.mybatisgenerator.core;

/**
 * @description:生成样式枚举
 *
 * @author: liwt
 * @date: 2019/8/20 15:13
 * @version: 1.0.1
*/
public enum EStyle {
    MYBATIS("mybatis.xml", "生成mybatis风格"),
    TKMYBATIS("tkmybatis.xml", "生成tkmybatis风格");

    /**生成地址*/
    private String address;
    /**生成描述*/
    private String describe;

    EStyle(String address, String describe) {
        this.address = address;
        this.describe = describe;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
