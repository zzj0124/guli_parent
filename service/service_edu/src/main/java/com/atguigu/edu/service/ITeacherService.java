package com.atguigu.edu.service;

import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.vo.QueryTeacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-07-13
 */
public interface ITeacherService extends IService<Teacher> {
    void pageQuery(Page<Teacher> pageParam, QueryTeacher queryTeacher);
}
