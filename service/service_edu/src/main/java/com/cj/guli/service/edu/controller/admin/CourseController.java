package com.cj.guli.service.edu.controller.admin;

import com.cj.guli.common.base.result.R;
import com.cj.guli.service.edu.entity.form.CourseInfoForm;
import com.cj.guli.service.edu.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */

@Api(tags = "课程管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@ApiOperation("新增课程")
	@PostMapping("save-course-info")
	public R saveCourseInfo(
			@ApiParam(value = "课程基本信息", required = true)
			@RequestBody CourseInfoForm courseInfoForm) {
		// 保存课程信息
		// 返回一个课程id
		String courseId = courseService.saveCourseInfo(courseInfoForm);
		return R.ok().data("courseId", courseId).message("保存成功");
	}

	@ApiOperation("根据id查询")
	@GetMapping("course-info/{id}")
	public R getById(
			@ApiParam(value = "课程ID", required = true)
			@PathVariable String id) {
		CourseInfoForm courseInfoForm = courseService.getCourseInfoById(id);
		if (courseInfoForm != null) {
			return R.ok().data("item", courseInfoForm);
		} else {
			return R.error().message("数据不存在");
		}
	}
}

