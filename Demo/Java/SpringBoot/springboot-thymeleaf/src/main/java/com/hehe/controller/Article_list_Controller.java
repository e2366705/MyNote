package com.hehe.controller;


import com.swjtu.util.GetFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/*
        文章列表
 */

@Controller
@RequestMapping(value="/Article_list_Controller")
public class Article_list_Controller {


    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model){

        String path = "src/main/java/com/hehe/Article/";

        GetFiles getFiles = new GetFiles();
        ArrayList<String> all_files =  getFiles.Start(path);

        model.addAttribute("result" , all_files);

        return "English_Article_list";
    }


}
