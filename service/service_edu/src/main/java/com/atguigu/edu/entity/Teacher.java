package com.atguigu.edu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EDU_TEACHER")
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师ID")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    @TableField("INTRO")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    @TableField("CAREER")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    @TableField("TEA_LEVEL")
    private Long teaLevel;

    @ApiModelProperty(value = "讲师头像")
    @TableField("AVATAR")
    private String avatar;

    @ApiModelProperty(value = "排序")
    @TableField("TEA_SORT")
    private Long teaSort;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("IS_DELETED")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "GMT_CREATE", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "GMT_MODIFIED", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
