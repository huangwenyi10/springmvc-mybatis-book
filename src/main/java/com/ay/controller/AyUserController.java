package com.ay.controller;
import com.ay.model.AyRole;
import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制层
 *@author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/user")
public class AyUserController {

    @RequestMapping("/hello")
    @ResponseBody
    public List<String> hello(){
        List<String> list = new ArrayList<String>();
        list.add("ay");
        list.add("al");
        return list;
    }

//    @RequestMapping("hello")
//    public ModelAndView hello(HttpMethod method){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name","ay");
//        mv.setViewName("hello");
//        return mv;
//    }


//    @RequestMapping("hello")
//    public ModelAndView hello(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name","ay");
//        mv.setViewName("hello");
//        return mv;
//    }

//    @RequestMapping("hello")
//    public String hello(Model model){
//        model.addAttribute("name", "ay");
//        return "hello";
//    }

//    @ModelAttribute
//    public void redirectTest(Model model){
//        model.addAttribute("name","ay");
//    }
//
//    @RequestMapping("hello")
//    public String hello(Model model, ModelMap modelMap, Map map){
//        return "hello";
//    }

//    @RequestMapping("redirect")
//    public String redirectTest(Model model,SessionStatus sessionStatus){
//        AyUser ayUser = new AyUser();
//        ayUser.setName("ay");
//        model.addAttribute("ayUser",ayUser);
//        sessionStatus.setComplete();
//        return "redirect:hello";
//    }
//
//    @RequestMapping("hello")
//    public String hello(@SessionAttribute AyUser ayUser){
//        System.out.println(ayUser.getName());
//        return "hello";
//    }

//    @RequestMapping("hello")
//    public String hello(ModelMap modelMap){
//        AyUser ayUser = (AyUser) modelMap.get("ayUser");
//        System.out.println(ayUser.getName());
//        return "hello";
//    }

//    @ModelAttribute("ayUser")
//    public AyUser init(@RequestParam("id") Integer id,
//                       @RequestParam("name") String name){
//        AyUser ayUser = new AyUser();
//        ayUser.setId(id);
//        ayUser.setName(name);
//        return ayUser;
//    }
//
//    @RequestMapping(value="hello")
//    public String hello(@ModelAttribute("ayUser") AyUser ayUser){
//
//        return "hello";
//    }

//    @ModelAttribute("name")
//    @RequestMapping(value = "/hello")
//    public String hello(){
//        return "ay";
//    }

//    @ModelAttribute("name")
//    public String init(@RequestParam(value = "name", required = false) String name){
//        return name;
//    }
//
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }

//    @ModelAttribute()
//    public void init(Model model){
//        AyUser ayUser = new AyUser();
//        ayUser.setId(1);
//        ayUser.setName("ay");
//        model.addAttribute("user", ayUser);
//    }
//
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }

//    @ModelAttribute
//    public void init(){
//        System.out.println("init ...");
//    }
//
//    @ModelAttribute
//    public void init02(){
//        System.out.println("init 02 ...");
//    }
//
//    @GetMapping("/findById/{id}")
//    public String findById(@PathVariable String id) {
//        // ...
//        return "";
//    }
//
//    @ModelAttribute
//    public void init03(){
//        System.out.println("init 03 ...");
//    }

//    @GetMapping("/findById/{id}")
//    public String findById(@PathVariable String id) {
//        // ...
//        return "";
//    }

//    @PostMapping(path = "/add")
//    public String add(@RequestBody AyUser ayUser) {
//        // ...
//        return "";
//    }



//    @RequestMapping("/cookieValue")
//    public String handle(@CookieValue("JSESSIONID") String cookie) {
//        //...
//        return "";
//    }

//    @RequestMapping("/requestHeader")
//    public String handle(
//            @RequestHeader("Accept-Encoding") String[] encoding,
//            @RequestHeader("Accept") String[] accept) {
//        //...
//       return "";
//    }

//    @RequestMapping("/pets/{petId}")
//    public String findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
//        // ...
//        return "";
//    }


//    @RequestMapping("/findByNameAndPassword")
//    public String findByNameAndPassword(
//                        @RequestParam(value="name") String name,
//                        @RequestParam(value="password",required = false,defaultValue = "123") String password){
//        System.out.println("name=" + name);
//        System.out.println("password" + password);
//        return "success";
//    }

    @Resource
    private AyUserService ayUserService;

    //    @RequestMapping("findById")
//    public String findById(@RequestParam(value="id") String id){
//        AyUser ayUser = ayUserService.findById(id);
//        return "success";
//    }

//    @RequestMapping(value = "/fetch", params = {
//            "personId=10"
//    })
//    public String getParams(@RequestParam("personId") String id) {
//        return "Fetched parameter using params attribute = " + id;
//    }
//    @RequestMapping(value = "/fetch", params = {
//            "personId=20"
//    })
//    public String getParamsDifferent(@RequestParam("personId") String id) {
//        return "Fetched parameter using params attribute = " + id;
//    }

//    @RequestMapping(value = "/head", headers = {
//            "content-type=text/plain",
//            "content-type=text/html"
//    }) String post() {
//        return "Mapping applied along with headers";
//    }

//    @RequestMapping(value = "/head", headers = {
//            "content-type=text/plain"
//    })
//    String post() {
//        return "Mapping applied along with headers";
//    }


//    @RequestMapping(value = "/produces", produces = {
//            "application/JSON"
//    })
//    @ResponseBody
//    String getProduces() {
//        return "Produces attribute";
//    }
//
//    @RequestMapping(value = "/consumes", consumes = {
//            "application/JSON",
//            "application/XML"
//    })
//    String getConsumes() {
//        return "Consumes attribute";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    String get() {
//        return "Hello from get";
//    }
//    @RequestMapping(method = RequestMethod.DELETE)
//    String delete() {
//        return "Hello from delete";
//    }
//    @RequestMapping(method = RequestMethod.POST)
//    String post() {
//        return "Hello from post";
//    }
//    @RequestMapping(method = RequestMethod.PUT)
//    String put() {
//        return "Hello from put";
//    }
//    @RequestMapping(method = RequestMethod.PATCH)
//    String patch() {
//        return "Hello from patch";
//    }
//
//    @RequestMapping(value = {
//            "",
//            "/page",
//            "page*",
//            "view/*,**/msg"
//    })
//    public String hello(Model model){
//        model.addAttribute("message", "hello ay");
//        return "hello";
//    }
//    @RequestMapping("/hello")
//    public String hello(Model model){
//        model.addAttribute("message", "hello ay");
//        return "hello";
//    }



//    @GetMapping("/findById")
//    public String findById(Model model){
//        AyUser ayUser = ayUserService.findById("1");
//        return "success";
//    }
//
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
