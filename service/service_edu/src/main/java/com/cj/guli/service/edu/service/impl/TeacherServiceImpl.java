package com.cj.guli.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.guli.common.base.result.R;
import com.cj.guli.service.edu.entity.Teacher;
import com.cj.guli.service.edu.entity.vo.TeacherQueryVo;
import com.cj.guli.service.edu.feign.OssFileService;
import com.cj.guli.service.edu.mapper.TeacherMapper;
import com.cj.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

	@Autowired
	private OssFileService ossFileService;

	@Override
	public IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo) {
		// 显示分页查询列表
		// 排序 按照sort字段排序
		QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByAsc("sort");

		// 分页查询
		if (teacherQueryVo == null) {
			return baseMapper.selectPage(pageParam, queryWrapper);
		}

		// 条件查询
		String name = teacherQueryVo.getName();
		Integer level = teacherQueryVo.getLevel();
		String joinDateBegin = teacherQueryVo.getJoinDateBegin();
		String joinDateEnd = teacherQueryVo.getJoinDateEnd();

		if (!StringUtils.isEmpty(name)) {
			queryWrapper.likeRight("name", name);
		}

		if (!StringUtils.isEmpty(level)) {
			queryWrapper.eq("level", level);
		}

		// 和数据库的字段对应
		if (!StringUtils.isEmpty(joinDateBegin)) {
			queryWrapper.ge("join_date", joinDateBegin);
		}

		if (!StringUtils.isEmpty(joinDateEnd)) {
			queryWrapper.le("join_date", joinDateEnd);
		}

		return baseMapper.selectPage(pageParam, queryWrapper);
	}

	/**
	 * List<Map<String,Object>>
	 * [
	 * {"name":"周杰伦"}
	 * {"name":"周润发"}
	 * ]
	 * select * from teacher where name like '周%'
	 *
	 * @param key 讲师姓名关键字
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectNameListByKey(String key) {
		QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
		queryWrapper.select("name");
		queryWrapper.likeRight("name", key);
		//返回值是Map列表
		return baseMapper.selectMaps(queryWrapper);
	}


	/**
	 * 删除照片
	 *
	 * @param id
	 */
	@Override
	public boolean removeAvatarById(String id) {
		Teacher teacher = baseMapper.selectById(id);
		if (teacher != null) {
			String avatar = teacher.getAvatar();
			if (!StringUtils.isEmpty(avatar)) {
				//删除图片
				R r = ossFileService.removeFile(avatar);

				log.info("删除图片成功");

				return r.getSuccess();
			}
		}
		return false;
	}


}
