package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    //登陆
    @PostMapping("/login")
    public String Login(@RequestBody User user){
        User u = userLoginService.searchByName(user.getUser_name());
        if(user.getUser_name()
                .equals(u.getUser_name())
                && user.getPassword()
                .equals(u.getPassword())){
            return "登陆成功";
        }else
            return "用户不存在或者用户名或密码错误";
    }

    //注册
    @PostMapping("/register")
    public String Register(@RequestBody User user){
        userLoginService.saveUser(user);
        return "注册成功";
    }

}
