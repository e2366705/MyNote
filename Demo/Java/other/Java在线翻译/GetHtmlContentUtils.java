package com.swjtu;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetHtmlContentUtils {
    private final static String PreUrl = "http://www.baidu.com/s?wd=";                        //百度搜索URL
    private final static String TransResultStartFlag = "<span class=\"op_dict_text2\">";      //翻译开始标签
    private final static String TransResultEndFlag = "</span>";                               //翻译结束标签


    @Test
    public void getTranslateResult() throws Exception {    //传入要搜索的单词

        String urlString = "desert";

        URL url = new URL(PreUrl + urlString);            //生成完整的URL
        // 打开URL
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // 得到输入流，即获得了网页的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        int flag = 1;
        String line;
        String preLine = "";
        String content = "";          //翻译结果

        //获取翻译结果的算法
        while ((line = reader.readLine()) != null) {
            if (preLine.contains(TransResultStartFlag) && !line.contains(TransResultEndFlag)) {
                content += line.replaceAll("　| ", "") + "\n";   //去掉源代码上面的半角以及全角字符
                flag = 0;
            }
            if (line.contains(TransResultEndFlag)) {
                flag = 1;
            }
            if (flag == 1) {
                preLine = line;
            }
        }
        System.err.println(content);
    }
}


