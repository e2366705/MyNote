package com.swjtu;


import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;


public class isChinese {


    @Test
    public void test01() {
        String str = "my friends gardens and we’ve become closer";

        if (str.getBytes().length == str.length()) {
            System.err.println("english....");
        }else {
            System.err.println("those string has chinese....");
        }
    }

    @Test
    public void IS_has_blank_space(){
        String str = "acd dd";
        if(str.contains(" ")){
            System.out.println("存在空格 , 是一个句子");
        }else{
            System.out.println("没有 空格");
        }
    }
}
