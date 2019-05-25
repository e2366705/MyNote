package com.xxxxxx.controller;


import com.xxxxxx.pojo.User;
import com.xxxxxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/aaa")
public class controller {

    @Autowired
    private UserService userService;


    // 访问地址
    //          http://localhost:8080/aaa/login.do
    @RequestMapping(value = "/login")
    public void login(){
        User user = userService.login("admin");
        System.err.println("==========================================");
        System.err.println(user.toString());
        System.err.println("==========================================");
    }

    //  访问路径
    //          http://localhost:8080/aaa/test.do
    @RequestMapping("/test")
    public void test(){
        System.err.println("==========================================");
        System.err.println("test do_something......");
        System.err.println("==========================================");
    }

}
