package com.cj.edu.controller;


import com.cj.edu.entity.Teacher;
import com.cj.edu.service.TeacherService;
import com.cj.edu.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-09
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@ApiOperation("教师列表接口")
	@GetMapping
	public R<List<Teacher>> list() {
		return R.success(teacherService.list(null));
	}

	@DeleteMapping("/{id}")
	public R<String> delete(@PathVariable String id) {
		teacherService.removeById(id);
		return R.success("删除成功");
	}

}

