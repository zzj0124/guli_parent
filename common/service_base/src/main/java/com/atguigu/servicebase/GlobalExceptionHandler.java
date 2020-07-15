package com.atguigu.servicebase;

import com.atguigu.commonutils.Res;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzj
 * @Date 2020/7/14 15:51
 * @Description: 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Res handleError(Exception e) {
        e.printStackTrace();
        return Res.error();
    }
}
