package com.ay.controller;
import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping(value = "/user")
public class AyUserController {

    @Resource
    private AyUserService ayUserService;

    @GetMapping("/findById")
    public String findById(Model model){
        AyUser ayUser = ayUserService.findById("1");
        return "success";
    }

//    @GetMapping("/findAll")
//    public String findAll(Model model){
//        List<AyUser> ayUserList = ayUserService.findAll();
//        for(AyUser ayUser : ayUserList){
//            System.out.println("id: " + ayUser.getId());
//            System.out.println("name: " + ayUser.getName());
//        }
//        return "hello";
//    }
//
//    @GetMapping("/findById")
//    public String findById(Model model){
//        AyUser ayUser = ayUserService.findById("1");
//        return "success";
//    }
//
//    @GetMapping("/findByName")
//    public String findByName(Model model){
//        List<AyUser> ayUsers = ayUserService.findByName("阿毅");
//        return "success";
//    }
//
//    @GetMapping("/countByName")
//    public String countByName(Model model){
//        int count = ayUserService.countByName("阿毅");
//        return "success";
//    }

//    @GetMapping("/insert")
//    public String insert(Model model){
//        AyUser ayUser = new AyUser();
//        ayUser.setId(3);
//        ayUser.setName("ay");
//        ayUser.setPassword("123");
//        int count = ayUserService.insert(ayUser);
//        return "success";
//    }

//    @GetMapping("/insert")
////    public String insert(Model model){
////        AyUser ayUser = new AyUser();
////        //ayUser.setId(3);
////        ayUser.setName("ay");
////        ayUser.setPassword("123");
////        int count = ayUserService.insert(ayUser);
////        return "success";
////    }
////
////    @GetMapping("/update")
////    public String update(Model model){
////        AyUser ayUser = new AyUser();
////        ayUser.setId(4);
////        ayUser.setName("al");
////        ayUser.setPassword("123");
////        int count = ayUserService.update(ayUser);
////        return "success";
////    }
////
////    @GetMapping("/delete")
////    public String delete(Model model){
////        int count = ayUserService.delete(4);
////        return "success";
////    }
////
////    @GetMapping("/deleteByName")
////    public String deleteByName(Model model){
////        int count = ayUserService.deleteByName("al");
////        return "success";
////    }
////
////    @GetMapping("/findByNameAndPassword")
////    public String findByNameAndPassword(Model model){
////        //List<AyUser> ayUsers = ayUserService.findByNameAndPassword("ay","123");
////        List<AyUser> ayUsers = ayUserService.findByNameAndPassword("al","123");
////        return "success";
////    }

//    @GetMapping("/findByNameAndPassword")
//    public String findByNameAndPassword(Model model){
//        //List<AyUser> ayUsers = ayUserService.findByNameAndPassword("ay","123");
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("name","al");
//        map.put("password","123");
//        List<AyUser> ayUsers = ayUserService.findByNameAndPassword(map);
//        return "success";
//    }

//    @GetMapping("/findByIds")
//    public String findByIds(Model model){
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        List<AyUser> ayUsers = ayUserService.findByIds(ids);
//        return "success";
//    }
}
