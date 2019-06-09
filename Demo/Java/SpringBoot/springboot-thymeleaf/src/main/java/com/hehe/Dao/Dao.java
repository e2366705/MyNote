package com.hehe.Dao;

import com.hehe.POJO.Words_Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class Dao {


    @Autowired
    private Mapper mapper;


    public List<Words_Warehouse> findAll() {

        List<Words_Warehouse> list = new ArrayList<>();

        List<Words_Warehouse> result = mapper.getAll();

        for (Words_Warehouse words_warehouse : result){
            System.out.println(words_warehouse.getChinese_meaning());
        }

        return list;
    }

    public List<Words_Warehouse> getOne() {

        List<Words_Warehouse> list = new ArrayList<>();

        Words_Warehouse result = mapper.getOne("b");

        System.out.println(result.toString());

        return list;
    }



    public String Find_chinese_mean_MYSQL(String word) {

        Words_Warehouse result = mapper.Find_chinese_mean_MYSQL(word);

        String chinese_mean = null;

        if (result != null){
            chinese_mean = result.getChinese_meaning();
        }

        System.out.println("数据库查到的翻译结果是:   "+ chinese_mean);

        return chinese_mean;
    }


    public int Get_words_length(String select_value) {

        int count = mapper.Get_words_length(select_value);

        System.out.println("查到的记录数是:   " + count +  "   条记录");

        return count;
    }




    public Words_Warehouse  Get_one_word(String words_length , int input_limit){

        List<Words_Warehouse> result = mapper.Get_one_word(words_length , input_limit);

        System.out.println("查到的记录数是:   " + result.get(0).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(1).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(2).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(3).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(4).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(5).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(6).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(7).toString() +  "   条记录");
//        System.out.println("查到的记录数是:   " + result.get(8).toString() +  "   条记录");

        return result.get(0);
    }





}
