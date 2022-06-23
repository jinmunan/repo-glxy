package com.cj.guli.service.edu.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.guli.common.base.result.R;
import com.cj.guli.service.edu.entity.Teacher;
import com.cj.guli.service.edu.entity.vo.TeacherQueryVo;
import com.cj.guli.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@CrossOrigin //解决跨域问题
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("教师列表")
    @GetMapping
    public R list() {
        return R.ok().data("items", teacherService.list(null));
    }

    @ApiOperation(value = "根据id删除教师", notes = "根据id删除教师,逻辑删除")
    @DeleteMapping("/{id}")
    public R delete(@ApiParam("讲师id") @PathVariable String id) {
        boolean result = teacherService.removeById(id);
        if (result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    /**
     * 分页查询和条件查询复用代码
     * 设置参数默认值
     *
     * @param page
     * @param limit
     * @param teacherQueryVo
     * @return
     * @RequestParam(defaultValue = "1")
     * @RequestParam(defaultValue = "10")
     */
    @ApiOperation(value = "教师分页列表(分页和条件)")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("查询对象") TeacherQueryVo teacherQueryVo) {

        Page<Teacher> pageParam = new Page<Teacher>(page, limit);
        IPage<Teacher> pageModel = teacherService.selectPage(pageParam, teacherQueryVo);
        long total = pageModel.getTotal();
        List<Teacher> teacherList = pageModel.getRecords();
        return R.ok().data("total", total).data("rows", teacherList);
    }

    /**
     * @param teacher
     * @return
     * @RequestBody 以json形式提交
     */
    @ApiOperation(value = "新增教师")
    @PostMapping("/save")
    public R save(@ApiParam("讲师对象") @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return R.ok().message("保存成功");
    }

    @ApiOperation(value = "更新教师")
    @PutMapping("/update")
    public R updateById(@ApiParam("讲师对象") @RequestBody Teacher teacher) {
        boolean result = teacherService.updateById(teacher);
        if (result) {
            return R.ok().message("更新成功");
        } else {
            return R.ok().message("数据不存在");
        }
    }

    @ApiOperation(value = "根据id获取讲师信息")
    @GetMapping("/get/{id}")
    public R getById(@ApiParam("讲师id") @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        if (teacher != null) {
            return R.ok().data("item", teacher);
        } else {
            return R.error().message("数据不存在");
        }
    }


}
