package com.ay.controller;

import com.ay.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：用户控制层
 *
 * @author Ay
 * @date 2018/6/6.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
}
