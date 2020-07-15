package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzj
 * @Date 2020/7/14 10:04
 * @Description: 统一返回结果类
 */
@Data
public class Res {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    private Res() {}

    public static Res ok() {
        Res r = new Res();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.getValue());
        r.setMessage(ResultCode.SUCCESS.getName());
        return r;
    }

    public static Res error() {
        Res r = new Res();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR.getValue());
        r.setMessage(ResultCode.ERROR.getName());
        return r;
    }

    public Res success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Res code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Res message(String message) {
        this.setMessage(message);
        return this;
    }

    public Res data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Res data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
