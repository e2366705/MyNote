package com.example.demo.service;

import com.example.demo.bean.User;

public interface UserLoginService {
    //拿用户名查用户对象
    User searchByName(String name);
    //将用户对象存进数据库
    void saveUser(User user);
}
