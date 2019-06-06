package com.xxxxxx.service.serviceImpl;

import com.xxxxxx.mapper.UserMapper;
import com.xxxxxx.pojo.User;
import com.xxxxxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public User login(String username) {
        return userMapper.login(username);
    }

}