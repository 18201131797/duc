package com.admin.enums;

/**
 * @description:是否删除枚举
 *
 * @author: liwt
 * @date: 2020/3/3 9:39
 * @version: 1.0.1
 */
public enum  EDelete {

    NODELETE(1,"未删除"),
    DELETE(0, "删除");


    private int code;

    private String name;

    EDelete(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
