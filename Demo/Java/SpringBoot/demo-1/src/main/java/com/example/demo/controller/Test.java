package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test {


    // 访问地址:     http://localhost:8083/test/test
    @GetMapping("/test")
    public void test(){
        System.err.println("************************************");
    }


}
