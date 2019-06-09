package com.swjtu;



import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByteStream {

    public static void main(String[] args) {

//        \src\main\java\com\swjtu

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/main/java/com/swjtu/test2.txt");
            String str = "1234567";
            byte[] outStr = str.getBytes("UTF-8"); // 读入字节数组，并指定编码方式
            fos.write(outStr); // 使用文件输出流写出到文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
