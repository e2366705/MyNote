package com.swjtu.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
        获取文章的内容
 */
public class Get_Article_content {

    public String Get_content(String file_name) {
        String path = "src/main/java/com/hehe/Article/";
        String file_path = path + file_name;
        String Article_content = "";

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file_path);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                Article_content += line;
            }

            System.out.println(Article_content);
            return Article_content;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "IOException";
    }
}



