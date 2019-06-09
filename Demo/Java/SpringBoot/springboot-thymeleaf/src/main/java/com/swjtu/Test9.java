package com.swjtu;


import org.junit.Test;

import java.util.Random;


public class Test9 {

    @Test
    //生成指定length的随机字符串（A-Z，a-z，0-9）
    public void getRandomString() {

        int length = 10;

        String str = "abcdefghijklm1no2pq3rs4tu5vw6xy7zA8BC9DE10FGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        System.out.println(sb.toString());
    }
}


