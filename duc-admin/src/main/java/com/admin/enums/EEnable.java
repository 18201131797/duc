package com.admin.enums;

/**
 * @description:是否可用枚举
 *
 * @author: liwt
 * @date: 2020/3/3 9:38
 * @version: 1.0.1
 */
public enum EEnable {

    TRUE(1,"可用"),
    FALSE(0, "停用");


    private int code;

    private String name;

    EEnable(int code, String name) {
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
