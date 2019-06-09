package com.swjtu;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;


public class Test7 {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, SQLException {


        File file = new File("D:\\TXT\\English.txt");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        Scanner scanner = new Scanner(file);

        //单词和数量映射表
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        String content = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            content = content + line + "\n";

            //\w+ : 匹配所有的单词
            //\W+ : 匹配所有非单词
//            String[] lineWords = line.split("\\W+");//用非单词符来做分割，分割出来的就是一个个单词
//            Set<String> wordSet = hashMap.keySet();
        }

        System.err.println("内容是:  " + content);

        HashSet<String> hs = new HashSet();

        String[] lineWords = content.split("\\W+");//用非单词符来做分割，分割出来的就是一个个单词

        for (int i = 0; i < lineWords.length; i++) {
            if (has_number(lineWords[i]) == true ){
                System.out.println("包含的有数字, 排除掉...");
            }else {
                hs.add(lineWords[i]);
            }
        }

        JDBC jdbc = new JDBC();

        int count = 0;

        //增强for循环
        for(String str:hs){
            Thread.sleep(120);
            count =  jdbc.Insert(str);
            System.out.println(str);
        }

        System.out.println("本次一共插入了   " + count + "  条数据");
    }

    public static boolean has_number(String str){

        //【全为英文】返回true  否则false
        boolean result1 = str.matches("[a-zA-Z]+");

        //【全为数字】返回true
        Boolean result6 = str.matches("[0-9]+");

        //【除英文和数字外无其他字符(只有英文数字的字符串)】返回true 否则false
        boolean result2 = str.matches("[a-zA-Z0-9]+");

        //【含有英文】true
        String regex1 = ".*[a-zA-z].*";
        boolean result3 = str.matches(regex1);

        // 含有数字 => true
        String regex2 = ".*[0-9].*";
        boolean has_number = str.matches(regex2);

        //判断是否为纯中文，不是返回false
        String regex3 = "[\\u4e00-\\u9fa5]+";
        boolean result5 = str.matches(regex3);

        System.out.println(has_number);

        return has_number;
    }
}


