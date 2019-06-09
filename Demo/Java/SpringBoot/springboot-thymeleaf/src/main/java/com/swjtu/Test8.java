package com.swjtu;

import com.swjtu.util.English_to_chinese;


public class Test8 {
    public static void main(String[] args) throws Exception {

        JDBC jdbc = new JDBC();
        String word = jdbc.Find_all_limit();
        System.out.println(word);

        English_to_chinese english_to_chinese = new English_to_chinese();
        String chinese_mean = english_to_chinese.getTranslateResult(word);

        System.out.println("获取的中文意思是:   " + chinese_mean);

        if (chinese_mean != null){
            int status = jdbc.update_chinese_mean(word , chinese_mean);
            if (status > 0){
                System.out.println("更新成功 ^_^ ");
            }
        }


    }
}
