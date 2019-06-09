package com.swjtu;

import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.tts.AbstractTTS;
import com.swjtu.tts.impl.BaiduTTS;
import com.swjtu.tts.impl.GoogleTTS;

import java.util.List;

public class TTS_test {
    public static void main(String[] args) {

        // https://github.com/hujingshuang/MTrans


        Querier<AbstractTTS> querierTTS = new Querier<>(); // 获取查询器

        querierTTS.setParams(LANG.EN, "To be or not to be, that is a question.apple is the");   // 设置参数

        querierTTS.attach(new GoogleTTS());  // 向查询器中添加 Google 翻译器

        List<String> result = querierTTS.execute(); // 执行查询并接收查询结果

        for (String str : result) {
            System.out.println(str);
        }
    }
}