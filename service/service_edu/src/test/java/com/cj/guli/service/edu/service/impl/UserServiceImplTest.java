package com.cj.guli.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.guli.service.edu.entity.User;
import com.cj.guli.service.edu.mapper.UserMapper;
import com.cj.guli.service.edu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


/**
 * Created by Jinmunan
 * 2022/6/22
 * 12:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        User user = new User();
        user.setName("张三");
        userService.save(user);
    }

    @Test
    public void page(){
        Page<User> page = new Page<User>(1,3);
        Page<User> userPage = userMapper.selectPage(page,null);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);

    }


    // 去除不必要的字段
    @Test
    public void pageMap(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        Page<Map<String,Object>> page = new Page<>(1,3);
        Page<Map<String, Object>> param = userMapper.selectMapsPage(page, queryWrapper);
        List<Map<String, Object>> records = param.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void delete(){
        userMapper.deleteById(2L);
    }

    @Test
    public void select(){
        userMapper.selectById(2L);
    }
}