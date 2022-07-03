package com.cj.guli.service.edu.service;

import com.cj.guli.service.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.guli.service.edu.entity.vo.SubjectVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
public interface SubjectService extends IService<Subject> {

	/**
	 * 读取excel并保存到数据库
	 */
	void batchImport(InputStream inputStream);

	/**
	 * 嵌套数据列表
	 * @return
	 */
	List<SubjectVo> nestList();
}
