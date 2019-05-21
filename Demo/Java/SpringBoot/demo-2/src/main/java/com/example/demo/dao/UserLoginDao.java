package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLoginDao extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.user_name=?1")
    User searchByName(String name);
}
