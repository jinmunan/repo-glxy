package com.cj.guli.service.edu.service.impl;

import com.cj.guli.service.edu.entity.Course;
import com.cj.guli.service.edu.entity.CourseDescription;
import com.cj.guli.service.edu.entity.form.CourseInfoForm;
import com.cj.guli.service.edu.mapper.CourseDescriptionMapper;
import com.cj.guli.service.edu.mapper.CourseMapper;
import com.cj.guli.service.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionMapper courseDescriptionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {
        // 保存课程基本信息
        Course course = new Course();
        course.setStatus(Course.COURSE_DRAFT); //草稿状态
        // 复制属性
        BeanUtils.copyProperties(courseInfoForm, course);
        baseMapper.insert(course);

        // 保存课程详情
        String courseId = course.getId();
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setId(courseId);
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescriptionMapper.insert(courseDescription);

        return courseId;

    }
}
