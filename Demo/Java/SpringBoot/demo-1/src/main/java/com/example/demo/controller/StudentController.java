package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/get/{name}")
    public Student getByName(@PathVariable String name){
        return studentService.searchByName(name);
    }

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.searchById(id);
    }

    @PostMapping("/delete/{name}")
    public void deleteByName(@PathVariable String name){
        studentService.deleteByName(name);
    }

    @PostMapping("/add")
    public void insertByName(Student student){
        studentService.insert(student);
    }
}
