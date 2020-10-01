package com.ay.controller;

import com.ay.model.AyRole;
import com.ay.model.AyUser;
import com.ay.service.AyRoleService;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping(value = "/role")
public class AyRoleController {

    @Resource
    private AyRoleService ayRoleService;

    @GetMapping("/findById")
    public String findById(Model model) {
        AyRole ayRole = ayRoleService.findById("1");
        return "success";
    }

}
