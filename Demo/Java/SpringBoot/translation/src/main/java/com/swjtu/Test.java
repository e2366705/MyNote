package com.swjtu;


import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.GoogleTranslator;

import java.util.List;

public class Test {

    @org.junit.Test
    public void Chinese_to_english(){
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.ZH, LANG.EN, "如果这都不算爱，我有什么好悲哀！");// 设置参数

        querierTrans.attach(new GoogleTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        for (String str : result) {
            System.out.println(str);
        }
    }


    @org.junit.Test
    public void English_to_chinese(){
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "apple is good");// 设置参数

        querierTrans.attach(new GoogleTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        for (String str : result) {
            System.out.println(str);
        }
    }

}