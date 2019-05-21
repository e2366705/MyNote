package com.example.demo.controller;

import com.example.demo.bean.Major;
import com.example.demo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController{
    @Autowired
    MajorService majorService;

    @GetMapping("/Test")
    public String Test(){
        return "Test_page";
    }

    @GetMapping("/getAll")
    public List<Major> getAll(){
        return majorService.findAll();
    }

    @GetMapping("/get/{name}")
    public Major getByName(@PathVariable String name){
        return majorService.searchByName(name);
    }

    @GetMapping("/get/{id}")
    public Major getById(@PathVariable Integer id){
        return majorService.searchById(id);
    }

    @PostMapping("/add/{name}")
    public void addByName(@PathVariable String name){
        majorService.insert(name);
    }

    @PostMapping("/delete/{name}")
    public void deleteByName(@PathVariable String name){
        majorService.deleteByName(name);
    }
}
