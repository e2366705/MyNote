package com.example.demo.service;

import com.example.demo.bean.Student;

import java.util.List;

public interface StudentService {
    //根据姓名查找
    Student searchByName(String name);
    //根据id查找
    Student searchById(int id);
    //添加Student对象
    void insert(Student student);
    //根据姓名删除
    void deleteByName(String name);
    //查询所有
    List<Student> findAll();
}
