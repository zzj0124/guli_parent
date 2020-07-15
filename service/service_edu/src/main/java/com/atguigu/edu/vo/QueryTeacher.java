package com.atguigu.edu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzj
 * @Date 2020/7/14 15:18
 * @Description: 封装 条件查找教师 的类
 */
@ApiModel(value = "teacher查询对象", description = "讲师查询对象封装")
@Data
public class QueryTeacher {

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;

}
