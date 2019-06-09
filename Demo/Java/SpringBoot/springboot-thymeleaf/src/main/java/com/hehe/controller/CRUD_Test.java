package com.hehe.controller;

import com.hehe.Dao.Dao;
import com.hehe.Dao.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CRUD_Test {

    @Autowired
    private Mapper mapper;

    @Autowired
    private Dao dao;



    @RequestMapping(value="/test_mybatis", method= RequestMethod.GET)
    public void test() {


//        dao.Get_one_word(5 , 2);

        System.out.println();

    }
}
