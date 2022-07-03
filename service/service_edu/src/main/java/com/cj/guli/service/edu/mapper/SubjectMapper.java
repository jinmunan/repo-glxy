package com.cj.guli.service.edu.mapper;

import com.cj.guli.service.edu.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.guli.service.edu.entity.vo.SubjectVo;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
public interface SubjectMapper extends BaseMapper<Subject> {

	/**
	 * 嵌套数据列表
	 * @param s
	 * @return
	 */
	List<SubjectVo> selectNestedListByParentId(String parentId);
}
