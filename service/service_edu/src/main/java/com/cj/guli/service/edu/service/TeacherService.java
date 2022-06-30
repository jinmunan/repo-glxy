package com.cj.guli.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.guli.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.guli.service.edu.entity.vo.TeacherQueryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 分页查询
     * @param pageParam 参数
     * @param teacherQueryVo 讲师vo
     * @return 讲师列表
     */
    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

    /**
     * 自动完成功能
     * @param key 讲师姓名关键字
     * @return 名字列表
     */
    List<Map<String, Object>> selectNameListByKey(String key);

    /**
     * 删除照片 调用feign接口删除oss
     * @param id
     */
    boolean removeAvatarById(String id);


}
