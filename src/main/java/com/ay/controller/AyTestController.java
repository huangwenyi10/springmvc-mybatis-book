package com.ay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping(value = "/test")
public class AyTestController {

    @GetMapping("/sayHello")
    public String sayHello(Model model) {
        return "hello";
    }
}
