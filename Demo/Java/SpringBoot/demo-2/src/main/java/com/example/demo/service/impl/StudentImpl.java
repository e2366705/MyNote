package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService{
    @Autowired
    StudentDao studentDao;


    @Override
    public Student searchByName(String name) {
        return studentDao.searchByName(name);
    }

    @Override
    public Student searchById(int id) {
        return studentDao.searchById(id);
    }

    @Override
    public void insert(Student student) {
        studentDao.save(student);
    }

    @Override
    public void deleteByName(String name) {
        studentDao.delete(studentDao.searchByName(name));
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
