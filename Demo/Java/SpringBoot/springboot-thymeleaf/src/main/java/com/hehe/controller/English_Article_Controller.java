package com.hehe.controller;

import com.hehe.Dao.Dao;
import com.swjtu.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/English_Article_Controller")
public class English_Article_Controller {


    @Autowired
    private Dao dao;

    @RequestMapping(value="/Add_Article", method= RequestMethod.GET)
    public String Add_Article(){
       return "Add_Article";
    }


    @RequestMapping(value="/Start", method= RequestMethod.POST)
    public void Start(String English_Article_title , String Article_content ){

//        English_Article_title;            文章标题
//        Article_content;             文章内容

        Article_to_words A_to_W = new Article_to_words();
        A_to_W.Start(Article_content);


        Save_Article_file save_article = new Save_Article_file();
        save_article.Start(English_Article_title , Article_content);

    }


    @RequestMapping(value="/Read_Article", method=RequestMethod.GET)
    public String english_Article(Model model , HttpServletRequest request, HttpServletResponse response , HttpSession session) {

        Get_Article_content get = new Get_Article_content();

        String file_name = request.getParameter("file_name");
        System.err.println("你点击的文件是:   " + file_name);

        String Article_content = get.Get_content(file_name);

        model.addAttribute("Article_content", Article_content);
        return "Read_Article";
    }





    IS_Chinese is_chinese = new IS_Chinese();
    Words_or_Sentence WorS = new Words_or_Sentence();
    English_to_chinese E_to_C = new English_to_chinese();

    @RequestMapping("translation")
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public Map<String,Object> translation(String english_words) throws Exception {

        System.out.println("你复制的单词/句子是:  " + english_words);

        String Translation_results = "";
        Map<String,Object> resultMap = new HashMap<String, Object>();

        Object status = is_chinese.isChinese_(english_words);      // 返回:  english / chinese

        // 判断是 中文/英文
        if (status != null  &&  status == "all_english"){
            // 再次判断是:   单词/句子
            int is_words_or_Sentence = WorS.getWords(english_words);

            if (is_words_or_Sentence > 1){
                // 句子 (Sentence)
                Translation_results =  E_to_C.English_Sentence_to_chinese(english_words);
                System.err.println(english_words);
                System.err.println(Translation_results);
                System.err.println("================================================");
                resultMap.put("sentence", true);
            }else {
                // 单词 (words)

                // 若是单词 , 第一步先是从数据库查询看有没有这个单词的意思 , 数据库若是没有, 再去联网查询
                String chinese_mean = dao.Find_chinese_mean_MYSQL(english_words);

                if (chinese_mean != null){
                    Translation_results = chinese_mean;
                }else {
                    Translation_results = E_to_C.getTranslateResult(english_words);
                    System.err.println(english_words);
                    System.err.println(Translation_results);
                }
                resultMap.put("words", true);
            }
        }

        resultMap.put("Translation_results", Translation_results);
        return resultMap;
    }





}
