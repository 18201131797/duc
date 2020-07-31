package com.core.thread.enums;

/**
 * @description:线程枚举
 *
 * @author: liwt
 * @date: 2020/7/31 11:22
 * @version: 1.0.1
 */
public enum ThreadPoolEnum {
    IO(0, "IO密集型"),
    CPU(1, "CPU密集型");

    private Integer code;
    private String name;

    ThreadPoolEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
