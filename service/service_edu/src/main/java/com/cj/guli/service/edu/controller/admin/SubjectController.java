package com.cj.guli.service.edu.controller.admin;


import com.cj.guli.common.base.result.R;
import com.cj.guli.common.base.result.ResultCodeEnum;
import com.cj.guli.common.base.util.ExceptionUtils;
import com.cj.guli.service.base.exception.GuliException;
import com.cj.guli.service.edu.entity.vo.SubjectVo;
import com.cj.guli.service.edu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@CrossOrigin //解决跨域问题
@Api(tags = "课程列表管理")
@RestController
@RequestMapping("/admin/edu/subject")
@Slf4j
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@ApiOperation("excel批量导入")
	@PostMapping("/import")
	public R batchImport(
			@ApiParam(value = "excel文件流", required = true)
			@RequestParam("file") MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			subjectService.batchImport(inputStream);
			return R.ok().message("批量导入成功");
		} catch (IOException e) {
			// 写到文件中
			log.error(ExceptionUtils.getMessage(e));
			throw new GuliException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
		}
	}


	@ApiOperation("excel列表")
	@GetMapping("nested-list")
	public R nestList() {
		List<SubjectVo> subjectVoList = subjectService.nestList();
		return R.ok().data("items", subjectVoList);
	}
}

