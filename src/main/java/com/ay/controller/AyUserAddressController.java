package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.model.AyUserAddress;
import com.ay.service.AyUserAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 描述：地址控制层
 *
 * @author Ay
 * @create 2018/05/01
 **/
@Controller
@RequestMapping(value = "/address")
public class AyUserAddressController {

    @Resource
    private AyUserAddressService ayUserAddressService;

    @GetMapping("/findById")
    public String findById(Model model) {
        AyUserAddress ayUserAddress = ayUserAddressService.findById(1);
        return "success";
    }
}
