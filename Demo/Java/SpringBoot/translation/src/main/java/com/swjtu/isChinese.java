package com.swjtu;


import org.junit.Test;


public class isChinese {


    @Test
    public void test01() {
        String str = "sdasdasdasdasdas";

        if (str.getBytes().length == str.length()) {
            System.err.println("those string has english....");
        }else {
            System.err.println("those string has chinese....");
        }
    }
}
