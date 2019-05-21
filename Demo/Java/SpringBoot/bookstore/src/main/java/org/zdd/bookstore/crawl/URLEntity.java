package org.zdd.bookstore.crawl;

import org.zdd.bookstore.model.entity.BookInfo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class URLEntity {

    //   category : 类别
    public static List<BookInfo> URLParse(HttpClient httpclient,
                                          String url,
                                          String category) throws IOException, ParseException {

        List<BookInfo> getbooks = new ArrayList<BookInfo>();

        HttpResponse response = HttpUtil.getHtml(httpclient, url);

        int statusCode = response.getStatusLine().getStatusCode();   //获取状态码

        // 200 is seccsess
        if(statusCode == 200){

            //   爬取网页的返回的源码   <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//...........
            String entity = EntityUtils.toString(response.getEntity(),"utf-8");


            // 返回书籍的详情 , id/price/name/athour/press/pages/size等等.......
            //  BookParse.getData
            getbooks = BookParse.getData(httpclient,entity,category);

            EntityUtils.consume(response.getEntity());   //消耗实体类，实体类最后需要消耗
        }
        else{
            EntityUtils.consume(response.getEntity());
        }

        return getbooks;    // 返回图书 实体类
    }
}
