package com.cj.guli.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cj.guli.service.edu.entity.Subject;
import com.cj.guli.service.edu.entity.excel.ExcelSubjectData;
import com.cj.guli.service.edu.entity.vo.SubjectVo;
import com.cj.guli.service.edu.listener.ExcelSubjectDataListener;
import com.cj.guli.service.edu.mapper.SubjectMapper;
import com.cj.guli.service.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

	/**
	 * @param inputStream excel文件流
	 */
	@Override
	@Transactional
	public void batchImport(InputStream inputStream) {
		EasyExcel.read(inputStream,
						ExcelSubjectData.class,
						// 向监听器传入一个mapper去处理插入操作,监听器没有被spring管理,不能注入
						new ExcelSubjectDataListener(baseMapper)).
				excelType(ExcelTypeEnum.XLS).
				sheet().
				doRead();

	}

	/**
	 * 嵌套数据列表
	 * @return
	 */
	@Override
	public List<SubjectVo> nestList() {
		return baseMapper.selectNestedListByParentId("0");
	}
}
