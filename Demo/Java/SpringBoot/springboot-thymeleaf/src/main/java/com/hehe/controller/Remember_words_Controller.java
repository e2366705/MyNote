package com.hehe.controller;


import com.hehe.Dao.Dao;
import com.hehe.POJO.Words_Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/Remember_words_Controller")
public class Remember_words_Controller {

    @Autowired
    private Dao dao;

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index() throws IOException {
        return "Remember_words";
    }



    @RequestMapping(value="/Get_words_length", method= RequestMethod.GET)
    @ResponseBody                               //此注解不能省略 否则ajax无法接受返回值
    public int Get_words_length( String words_length ) {

        System.out.println(words_length);

        int words_count = dao.Get_words_length(words_length);

        return words_count;
    }


    @RequestMapping(value="/Get_one_word", method= RequestMethod.GET)
    @ResponseBody                               //此注解不能省略 否则ajax无法接受返回值
    public List<String> Get_one_word( String words_length  , int input_limit ) {

        List<String> list = new ArrayList<String>();

        System.out.println(words_length  +  "             "  +  input_limit);

        Words_Warehouse search_result = dao.Get_one_word(words_length  , input_limit);

        list.add(search_result.getWord());
        list.add(search_result.getChinese_meaning());

        return list;
    }





}
