package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.dao.UserLoginDao;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginImpl implements UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;


    @Override
    public User searchByName(String name) {
        return userLoginDao.searchByName(name);
    }

    @Override
    public void saveUser(User user) {
        userLoginDao.save(user);
    }
}
