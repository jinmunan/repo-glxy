package com.cj.guli.service.edu.service;

import com.cj.guli.service.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.guli.service.edu.entity.form.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);

    // 根据courseId回显数据
	CourseInfoForm getCourseInfoById(String id);
}
