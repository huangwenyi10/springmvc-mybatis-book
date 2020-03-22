package com.ay.controller;
import com.ay.dto.SysUserDTO;
import com.ay.model.SysUser;
import com.ay.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户控制层
 * Created by Ay on 2020/3/22.
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<SysUser> users = sysUserService.findAll();
        model.addAttribute("users", convertToDTO(users));
        return "userManage";
    }

    @GetMapping("/in")
    public String userIn(Model model){
        return "userIn";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody SysUserDTO user){
        sysUserService.save(user);
        return "redirect:findAll";
    }

    private List<SysUserDTO> convertToDTO(List<SysUser> users){
        if(CollectionUtils.isEmpty(users)){
            return Collections.EMPTY_LIST;
        }
        List<SysUserDTO> userList = new ArrayList<SysUserDTO>();
        for(SysUser user: users){
            SysUserDTO userDTO = new SysUserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setNo(user.getNo());
            userDTO.setPosition(user.getPosition());
            if("1".equals(user.getStatus())){
                userDTO.setStatus("在职");
            }
            if("2".equals(user.getStatus())){
                userDTO.setStatus("已离职");
            }
            userList.add(userDTO);
        }
        return userList;
    }
}
