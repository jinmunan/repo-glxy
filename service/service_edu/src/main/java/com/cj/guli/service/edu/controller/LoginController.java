package com.cj.guli.service.edu.controller;

import com.cj.guli.common.base.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jinmunan
 * 2022/6/24
 * 15:04
 */


/**
 * mock伪造API
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/user")
public class LoginController {

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public R info() {
        return R.ok().data("name", "admin")
                .data("roles", "[admin]")
                .data("avatar","https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public R logout() {
        return R.ok();
    }
}
