package com.atguigu.edu.controller;


import com.atguigu.commonutils.Res;
import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.service.ITeacherService;
import com.atguigu.edu.vo.QueryTeacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器-讲师管理
 * </p>
 *
 * @author zzj
 * @since 2020-07-13
 */

@Api(description="讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    // 查询所有讲师
    @ApiOperation(value = "获取所有讲师列表")
    @GetMapping("/findAll")
    public Res findAllTeacher() {
        List<Teacher> list = teacherService.list(null);
        return Res.ok().data("allTeachers", list);
    }

    // 根据id删除
    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public Res removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                                     @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        return flag ? Res.ok() : Res.error();
    }

    @ApiOperation(value = "分页")
    @GetMapping("/{page}/{size}")
    public Res pageList(@PathVariable int page, @PathVariable int size) {
        Page<Teacher> pageParam = new Page<>(page, size);
        teacherService.page(pageParam, null);
        List<Teacher> items = pageParam.getRecords();
        long total = pageParam.getTotal();

        return Res.ok().data("total", total).data("items", items);
    }

    @ApiOperation(value = "条件查找&分页")
    @PostMapping("/{page}/{size}")
    public Res pageList(@PathVariable int page, @PathVariable int size,
                        @RequestBody QueryTeacher queryTeacher) {
        Page<Teacher> pageParam = new Page<>(page, size);
        teacherService.pageQuery(pageParam, queryTeacher);
        List<Teacher> items = pageParam.getRecords();
        long total = pageParam.getTotal();

        return Res.ok().data("total", total).data("items", items);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public Res save(@ApiParam(name = "teacher", value = "讲师对象", required = true)
                        @RequestBody Teacher teacher) {
        boolean result = teacherService.save(teacher);

        return result ? Res.ok() : Res.error();
    }

    @ApiOperation(value = "根据id查找讲师")
    @GetMapping("{id}")
    public Res selectById(@ApiParam(name = "id", value = "讲师ID", required = true)
                             @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return teacher != null ? Res.ok().data("item", teacher) : Res.error();
    }

    @ApiOperation(value = "根据id修改讲师")
    @PutMapping("/{id}")
    public Res updateById(@ApiParam(name = "id", value = "讲师id", required = true)
                          @PathVariable String id,
                          @ApiParam(name = "teacher", value = "讲师", required = true)
                          @RequestBody Teacher teacher) {
        teacher.setId(id);
        boolean result = teacherService.updateById(teacher);
        return result ? Res.ok() : Res.error();
    }
}

