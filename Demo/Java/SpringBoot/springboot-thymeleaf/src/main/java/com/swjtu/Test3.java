package com.swjtu;

import org.junit.Test;

public class Test3 {

    // 判断一个字符是否是中文
    public boolean isChinese(char c) {
        return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
    }


    // 判断一个字符串是否含有中文
    @Test
    public void isChinese() {
        String str = "my friends gardens and we’ve become closer 关闭 ";
        if (str == null){
            // return "null___";
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                System.out.println("含有中文");
                // return "has_chinese";          // 有一个中文字符就返回
            }
        }
        // return "no_chinese";
    }
}


