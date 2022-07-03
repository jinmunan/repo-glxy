package com.cj.guli.service.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cj.guli.service.edu.entity.Subject;
import com.cj.guli.service.edu.entity.excel.ExcelSubjectData;
import com.cj.guli.service.edu.mapper.SubjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Jinmunan
 * 2022/7/3
 * 15:38
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSubjectDataListener extends AnalysisEventListener<ExcelSubjectData> {


	private SubjectMapper subjectMapper;

	/**
	 * 遍历每一行的记录
	 *
	 * @param data
	 * @param context
	 */
	@Override
	public void invoke(ExcelSubjectData data, AnalysisContext context) {
		log.info("解析到一条数据:{}", data);
		// 处理读取进来的数据
		String titleLevelOne = data.getLevelOneTitle();
		String titleLevelTwo = data.getLevelTwoTitle();

		// 判断一级分类是否重复
		Subject subjectLevelOne = this.getByTitle(titleLevelOne);
		String parentId = null;
		if (subjectLevelOne == null) {
			//将一级分类存入数据库
			Subject subject = new Subject();
			// 一级标题
			subject.setParentId("0");
			subject.setTitle(titleLevelOne);//一级分类名称
			subjectMapper.insert(subject);
			parentId = subject.getId();
		} else {
			// 一级标题重复,不做任何操作
			parentId = subjectLevelOne.getId();
		}

		// 判断二级分类是否重复 parentId是一级标题
		Subject subjectLevelTwo = this.getSubByTitle(titleLevelTwo, parentId);
		if (subjectLevelTwo == null) {
			//将二级分类存入数据库
			Subject subject = new Subject();
			subject.setTitle(titleLevelTwo);
			subject.setParentId(parentId);
			subjectMapper.insert(subject);//添加
		}
	}

	/**
	 * 所有数据解析完成了 都会来调用
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		log.info("所有数据解析完成！");
	}

	/**
	 * 根据分类名称查询这个一级分类是否存在
	 *
	 * @param title
	 * @return
	 */
	private Subject getByTitle(String title) {

		LambdaQueryWrapper<Subject> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Subject::getTitle, title);
		queryWrapper.eq(Subject::getParentId, "0");//一级分类
		return subjectMapper.selectOne(queryWrapper);
	}

	/**
	 * 根据分类名称和父id查询这个二级分类是否存在
	 *
	 * @param title
	 * @return
	 */
	private Subject getSubByTitle(String title, String parentId) {
		LambdaQueryWrapper<Subject> queryWrapper = new LambdaQueryWrapper<>();

		queryWrapper.eq(Subject::getTitle, title);
		queryWrapper.eq(Subject::getParentId, parentId);//一级分类

		return subjectMapper.selectOne(queryWrapper);
	}
}