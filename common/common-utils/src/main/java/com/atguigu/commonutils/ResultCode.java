package com.atguigu.commonutils;

public enum ResultCode {
    SUCCESS(1,"成功"),ERROR(0,"失败");
    private ResultCode(Integer value,String name){
        this.value = value;
        this.name = name;
    }
    private final Integer value;
    private final String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
