package com.cj.guli.service.edu.service.impl;

import com.cj.guli.service.edu.entity.User;
import com.cj.guli.service.edu.mapper.UserMapper;
import com.cj.guli.service.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinmunan
 * @since 2022-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
