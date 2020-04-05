

# 注意: SpringBoot是不用自己去配置Tomcat的!!!
### 注意: SpringBoot是不用自己去配置Tomcat的!!!
### 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....
SpringBoot 自己内置了一个小型的服务器
方便快捷, 适用于快速开发





















<details>
<summary><b> 这是我遇到过的最奇怪的Bug </b></summary>

```

在这段代码中 οnclick 和 onclick 是不一样的:
    <button οnclick="send()">Send</button>
    <button onclick="send()">Send</button>
    <button οnclick="closeWebSocket()">Close</button>
不信可以 Ctrl + F 搜索: onclick 试一试?

```
</details>



























### 安装 Java
<details>
<summary><b> 安装 </b></summary>

```  

详情见 :    Markdown笔记\各种软件安装与配置.md

```
</details>
























# Java 规范
* 写出更加合理, 方便维护的代码
<details>
<summary><b>  规范 1 </b></summary>

```  

文件路径不要用 \ , 要用 /
读取文件的路径不要用:  src\main\Java\Tools_10\Audio\no_Chinese_meaning.MP3  这种格式
因为这种格式在 Windows 平台可以用, 移植到 mac 平台就没法用了, 会报错: 找不到路径

推荐使用: src/main/Java/Tools_10/Audio/no_Chinese_meaning.MP3  这个方式
这种格式在 Windows和mac 平台都可以用, 
移植性较强, 不需要改原来的代码


系统 Windows 中回车换行 : \r\n


字符串比较用  equals
    Java 中 String类中被复写的equals()方法其实是比较两个字符串的内容


一个方法, 只写一种功能, 然后返回这个方法处理后的数据,交给主方法去处理, 目的是为了更好的解耦性, 
主方法写逻辑



```
</details>























<details>
<summary><b> 规范: POJO 类(实体类) </b></summary>

```  
一定要有 
    * getter / setter 方法
    * toString方法
    * 带参构造方法
    * 无参构造方法
```
</details>




























<details>
<summary><b>Java 播放 MP3 音频文件 </b></summary>

```  
maven: pom.xml 添加:

    <!-- https://mvnrepository.com/artifact/javazoom/jlayer -->
    <dependency>
        <groupId>javazoom</groupId>
        <artifactId>jlayer</artifactId>
        <version>1.0.1</version>
    </dependency>




导包:
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;


 @Test
    public void PlayMusic() throws MalformedURLException, InterruptedException, JavaLayerException, FileNotFoundException {
        Player player;
        File music;

        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("D:\\Download________\\Browser_Download\\5c892a30468f811812.mp3"));
        player = new Player(buffer);
        player.play();
    }

```
</details>









































<details>
<summary><b> 控制台获取输入 Scanner  </b></summary>

```  

        String aaa = "";
        Scanner scan_prefix = new Scanner(System.in);
        System.err.println("----------------------------    请输入你要命名的名字的前缀 :  ");
        // 判断是否还有输入
        if (scan_prefix.hasNextLine()) {
            aaa = scan_prefix.nextLine();
            System.out.println(aaa);
        }


```
</details>






























<details>
<summary><b> 网络 / URI / URL / 链接地址 </b></summary>

```  


    // 完整请求连接:     http://localhost:8085/TTS?word=miss
    // -----------------------------------------------------------------------------------
    //   getRequestURL :  http://localhost:8085/TTS
    System.err.println("getRequestURL :  "+request.getRequestURL());

    //  getRequestURI :  /TTS
    System.err.println("getRequestURI :  "+request.getRequestURI());

    // 当前链接使用的协议 : http
    System.err.println("getScheme (当前链接使用的协议  )  :  " +  request.getScheme());

    //  服务器地址   :  localhost
    System.err.println("getServerName:  " + request.getServerName());

    //   端口号:  8085
    System.err.println("getServerPort (端口号):  " +  request.getServerPort());

    //   请求的相对url :  /TTS
    System.err.println("getServletPath (请求的相对url)  :  " +  request.getServletPath());

    // 额外参数   word=miss  返回 : miss
    System.err.println(request.getParameter("word"));

    // 目前未知
    System.err.println("getContextPath:  " + request.getContextPath());



    获取 本地 文件夹目录:
    public String upload(HttpServletRequest req, @RequestParam("file"))
    req.getServletContext().getRealPath("");
    输出:
        C:\Users\SpringBoot\IdeaProjects\springboot\src\main\webapp\

```
</details>
























<details>
<summary><b> 爬虫 / 获取网页源码 </b></summary>

```  

注意:
    一定要加上 %20  表示空格的意思
    第一种就获取不到源码
    第二种才可以

https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=i miss you       -> 格式错误
https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=i%20miss%20you   -> 正确






import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetSourceCode2 {
    public static void main(String[] args){
        try{
            URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=xinlei&key=759115437&type=data&doctype=json&version=1.1&q=i%20miss%20you");//网址链接
            URLConnection conn = url.openConnection(); //打开链接
            //获取网页的源代码
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GetSourceCode2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetSourceCode2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



返回 :
{"translation":["我想念你"],"basic":{"explains":["我想你；思念（歌名）"]},"query":"I Miss You","errorCode":0,"web":[{"value":["我想你","思念","想念你朋友"],"key":"I miss you"},{"value":["我非常想念你","我非常的想念你"],"key":"I very miss you"},{"value":["我想飞"],"key":"i am miss you"}]}





JSONObject jsonobj = new JSONObject("{\"translation\":[\"我想念你\"],\"basic\":{\"explains\":[\"我想你；思念（歌名）\"]},\"query\":\"I Miss You\",\"errorCode\":0,\"web\":[{\"value\":[\"我想你\",\"思念\",\"想念你朋友\"],\"key\":\"I miss you\"},{\"value\":[\"我非常想念你\",\"我非常的想念你\"],\"key\":\"I very miss you\"},{\"value\":[\"我想飞\"],\"key\":\"i am miss you\"}]}");

JSONArray jsonArray = (JSONArray) jsonobj.get("translation");
String result = jsonArray.getString(0);



//  i miss you  转换成  i%20miss%20you
public String Check(String word){
    word = word.replaceAll(" ", "%20");
    System.out.println("转换后的字符串:            "+word);
    return word;
}



```
</details>



































<details>
<summary><b> 解析 Json / json 取值  </b></summary>

```  



详细教程 :  https://juejin.im/post/5a31e4396fb9a044fd11c6a8


-----------------------------------   解析 json   ----------------------------------- 
解析: 第一种方式:
import org.json.JSONArray;
import org.json.JSONObject;
public class Json_2 {
    public static void main(String[] args) {
        String jsonData = "[{'name':'Aaa','age':11} , {'name':'Bbb','age':22} , {'name':'CCC','age':33}]";
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0; i < jsonArray.length(); i++)    {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                int age = jsonObject.getInt("age");
                System.err.println(name);
                System.err.println(age);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}







解析: 第二种方式:
import org.json.JSONObject;
import org.junit.Test;
import java.util.HashMap;

public class JSON_Alibaba {
        @Test
        public void test2(){
            String json_data = "{'name':'xiazdong','age':20}";
            JSONObject jsonobj = new JSONObject(json_data);
            String name = jsonobj.getString("name");
            int age = jsonobj.getInt("age");
            System.out.println("name = " + name + ",age = " + age);
        }







解析: 第三种方式:
    import org.json.JSONException;
    import org.json.JSONObject;

    @Test
    public void test3() throws JSONException {
        String json_data = "{\"ROOT\":{\"第一层\":{\"name\":\"Jack\",\"age\":18},\"第二层\":\"Javascript\"},\"error\":0,\"msg\":\"succ\"}";
        JSONObject jsonobj = new JSONObject(json_data);

        JSONObject data = (JSONObject) jsonobj.get("ROOT");

        System.out.println("data.length:        "+data.length());     // 2
        System.out.println("data.toString:      "+data.toString());   // {"第一层":{"name":"Jack","age":18},"第二层":"Javascript"}
        System.out.println("data.names:         "+data.names());      // ["第一层","第二层"]

        JSONObject fanyi = (JSONObject) data.get("第一层");
        String fanyi_result = String.valueOf(fanyi.get("age"));       // 18
        System.out.println(fanyi_result);
    }








-----------------------------------   格式化 json   ------------------------------------
        String json = "{'name':'Tom',     'age':18,    'adress':'china',    'weight':'66kg'}";
        JSONObject jsonObj = new JSONObject(json);
        String name = jsonObj.getString("name");
        System.out.println(jsonObj);       //  {"name":"Tom","weight":"66kg","adress":"china","age":18}
        System.out.println(name);          //  Tom

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(jsonObject));    
        输出:
            {
            "name": "Tom",
            "age": 18,
            "adress": "china",
            "weight": "66kg"
            }        



    美化 json 格式:
    public static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }







-----------------------------------   json   ------------------------------------

    String json = "{'name':'Tom',     'age':18,    'adress':'china',    'weight':'66kg'}";
    JSONObject jsonObj = new JSONObject(json);
    String name = jsonObj.getString("name");
    jsonObj.put("initial", name.substring(0, 2).toUpperCase());
    String[] likes = new String[] { "JavaScript", "Skiing", "Apple Pie" };
    jsonObj.put("QAQ", likes);
    System.out.println(jsonObj);
    输出:
        {"QAQ":["JavaScript","Skiing","Apple Pie"],"initial":"TO","name":"Tom","weight":"66kg","adress":"china","age":18}




    String json = "{'name':'Tom',     'age':18,    'adress':'china',    'weight':'66kg'}";
    JSONObject jsonObj = new JSONObject(json);
    Map <String, String> ingredients = new HashMap <String, String>();
    ingredients.put("apples", "3kg");
    ingredients.put("sugar", "1kg");
    ingredients.put("pastry", "2.4kg");
    ingredients.put("bestEaten", "outdoors");
    jsonObj.put("AAA", ingredients);
    System.out.println(jsonObj);
    输出:
        {"AAA":{"pastry":"2.4kg","apples":"3kg","sugar":"1kg","bestEaten":"outdoors"},"name":"Tom","weight":"66kg","adress":"china","age":18}
    

```
</details>













































<details>
<summary><b> 日历 / 日期 / 时间 </b></summary>

```  


    返回当前时间 (小心里面有个 Date 可能会和 sql 里面的 Date 发生冲突):
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    System.out.println( "现在是:  " +  df.format(new java.util.Date()));// new Date()为获取当前系统时间

    System.out.printf("现在是:  %66s  \n" , df.format(new java.util.Date()));
    System.out.printf("现在是:  %-66s   " , df.format(new java.util.Date()));








----------------------------------   获取当前时间戳   ----------------------------------
 System.currentTimeMillis()
 System.out.println(System.currentTimeMillis());









----------------------------------   测试程序代码运行时间  ----------------------------------
以 毫秒 为单位:
    long start_Time =System.currentTimeMillis();   //获取开始时间
    Thread.sleep(1231);
    long end_Time =System.currentTimeMillis(); //获取结束时间
    System.out.println("程序运行时间： "+(end_Time-start_Time)+"  ms");

以 纳秒 为单位:
    long startTime=System.nanoTime();   //获取开始时间
    Thread.sleep(1231);
    long endTime=System.nanoTime(); //获取结束时间
    System.out.println("程序运行时间： "+(endTime-startTime)+"  ns");










字符串格式的时间 / 时间格式的时间 的转化:
    String date = "2020-02-11";
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

    Date date1 = new Date(String.valueOf(format.parse(date)));
    System.out.println(date1);          // 输出:  Sat Jan 11 14:02:00 CST 2020

    String string_date = format.format(date1);
    System.out.println(string_date);       // 输出 :   2020-02-11





时间 / 日期排序:
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;


        ArrayList<String> timeList = new ArrayList<String>();
        timeList.add("2020-02-09 20:20");
        timeList.add("2020-02-15 10:20");
        timeList.add("2020-02-16 20:20");
        timeList.add("2020-02-08 20:20");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm");
        ArrayList<Date> dateList = new ArrayList<Date>();

         // 字符串转时间
        for (String str : timeList) {
            try {
                dateList.add(format.parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        // 打印排序前的时间
        System.out.println("排序前：");
        for(Date d:dateList){
            System.out.println(format.format(d));
        }


        // 开始排序:
        Sort sort = new Sort();
        sort.Date_Small_to_big(dateList);
//        sort.Date_big_to_small(dateList);


        System.out.println("排序后：");
        for(Date d:dateList){
            System.out.println(format.format(d));
        }



// 冒泡排序
class Sort{

    Date tempDate = null;

    //  排序 : 从小到大
    public ArrayList<Date> Date_Small_to_big(ArrayList<Date> dateList){
        for (int i = dateList.size()- 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if(dateList.get(j+1).before(dateList.get(j))){
                    tempDate = dateList.get(j);
                    dateList.set(j, dateList.get(j+1));
                    dateList.set(j+1, tempDate);
                }
            }
        }
        return dateList;
    }

    // 排序 : 从大到小
    public ArrayList<Date> Date_big_to_small(ArrayList<Date> dateList){

        for (int i = dateList.size()- 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if(dateList.get(j+1).after(dateList.get(j))){
                    tempDate = dateList.get(j);
                    dateList.set(j, dateList.get(j+1));
                    dateList.set(j+1, tempDate);
                }
            }
        }
        return dateList;
    }

}


```
</details>



































<details>
<summary><b> 字符串之: System.out.printf 格式化 </b></summary>

```  

基本长度:
    String aaaaa = "";      // 0
    String bbbbb = " ";     // 1
    String ccccc = "Q";     // 1
    String ddddd = "3";     // 1
    String eeeee = ".";     // 1
    String fffff = "三";    // 1
    String nnnnn = null;    // 1

    System.out.println(aaaaa.length());
    System.out.println(bbbbb.length());
    System.out.println(ccccc.length());
    System.out.println(ddddd.length());
    System.out.println(eeeee.length());
    System.out.println(fffff.length());
    System.out.println(nnnnn.length());



%s 很万能, 可以连接字符串, 布尔值, null值, 数值
    String str=null;

    str=String.format("Hi,%s , %s , %s", "AAA","BBB","CCC");
    System.out.println(str);

    str=String.format("Hi!   %s  ",  100.12345);
    System.out.println(str);

    str=String.format("Hi!   %s  ",  true);
    System.out.println(str);

    str=String.format("Hi!   %s  ",  "Tom_jack");
    System.out.println(str);

    str=String.format("Hi!   %s  ",  null);
    System.out.println(str);
    输出:
        Hi,AAA , BBB , CCC
        Hi!   100.12345  
        Hi!   true  
        Hi!   Tom_jack  
        Hi!   null      



    System.out.printf("单词:%-66s 出现次数:%d\n", "aaa", 123);
    System.out.printf("单词:%-66s 出现次数:%d\n", "eqweqweqweqweqw", 3123123);
    System.out.printf("单词:%-66s 出现次数:%d\n", "q", 7);

格式化输出结果:
    单词:aaa                                                                出现次数:123
    单词:eqweqweqweqweqw                                                    出现次数:3123123
    单词:q                                                                  出现次数:7    


    有两种方式:
    System.out.printf("现在是:  %66s  \n" , df.format(new Date()));
    System.out.printf("现在是:  %-66s   " , df.format(new Date()));

    注意:
    不是 System.err.println 
    而是 System.err.printf

    在 idea 中使用 souf 可以打出来
                
```
</details>


























<details>
<summary><b>字符串之: 是否含有英文 / 中文 / 数字 / 替换 / 随机数 / 随机字符串 / 截取字符串</b></summary>

```  


系统 Windows 中回车换行 : \r\n



---------------------------------   == 和 equals 的区别   ---------------------------------
        Integer iii1 = new Integer(1);
        Integer iii2 = new Integer(1);
        System.out.println(iii1 == iii2);		//  返回 false , 因为比较的是内存地址
        System.out.println(iii1.equals(iii2));	//  返回 true  , 因为比较的是数值的大小

        总结:
            ==      除了比较基本数据之外都是比较的内存地址 , 比较的是引用,不是内容
            equals  除了没有没有重写equals方法的类之外都是比较的内容
            
            字符串比较用  equals , Java 中 String类中被复写的equals()方法其实是比较两个字符串的内容



---------------------------------   大小写   ---------------------------------
        大写:
        str.toUpperCase();

        小写:
        str.toLowerCase()    




---------------------------------   字符串是否包含某个字符   ---------------------------------

# 1:
    String str = "我叫王力宏";
    boolean status = str.contains("力");
    if(status){
        System.out.println("包含");
    }else{
        System.out.println("不包含");
    }

# 2:
    String str = "aaa This is test for string";
    System.out.println(str.indexOf("test"));                     // 找到了,就返回索引位置
    System.out.println(str.indexOf("for string       "));        // 没找到,就返回 -1
    System.out.println(str.indexOf("aaa",3));                    // 从指定位置(第四个)开始查询        

# 3: 
    String parent = "this bbb bbbc  11bbb23 Bbb ";
    String child = "bbb";

    int count = 0;
    int index = 0;
    while( ( index = parent.indexOf(child, index) ) != -1 ){
        index = index+child.length();
        count++;
    }
    System.out.println( "匹配个数为        "+count );		//结果输出 : 匹配个数为        3









    @Test
    public void test() {

        String str = "asdasdas.";

        //单词是否全为英文
        // true  false
        boolean Whether_all_english = str.matches("[a-zA-Z]+");

        // 是否全为数字
        // true false
        Boolean all_number = str.matches("[0-9]+");

        // 除英文和数字外无其他字符(只有英文数字的字符串)
        //  true false
        boolean result2 = str.matches("[a-zA-Z0-9]+");

        // 含有英文
        //  true false
        String regex1 = ".*[a-zA-z].*";
        boolean has_english = str.matches(regex1);

        // 含有数字 
        //  true false
        String regex2 = ".*[0-9].*";
        boolean has_number = str.matches(regex2);


        // 是否包含一个空格
        String str = "acd dd";
        if(str.contains(" ")){
            System.out.println("存在空格 , 是一个句子");
        }else{
            System.out.println("没有 空格");
        }


        // 多少个单词(不包括汉字)
        String word = "abc cba CCC 哈哈哈 *** ### 000 111 ";
        String[] arr = word.split("[^a-zA-Z0-9]+");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("There are " + arr.length + "   english words in the line!");


        
        // 判断首字母是否大写?
        // 大写 => true
        public boolean First_letter_is_capitalized(String str) {
            char[] chars = str.toCharArray();
            return Character.isUpperCase(chars[0]);
        }

        // 字符串是否包含大写字母?
        String word = "asda1231^&%^&*er,..<><>[]]()*/-+sdfsdfAAA";
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (Character.isUpperCase(c)){
                    System.out.println("包含");
                }
            }








---------------------------------   检测中文   ---------------------------------

        // 是否有中文? 允许有符号
        String str = "my friends gardens and we've become closer '' * & ^ % # @ ! ` ~     ";
        if (str.getBytes().length == str.length()) {
            System.err.println("english....");
        }else {
            System.err.println("those string has chinese....");
        }


        //判断是否为纯中文
        //  true false
        String regex3 = "[\\u4e00-\\u9fa5]+";
        boolean all_chinese = str.matches(regex3);



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class How_many_chinese {

    public static void main(String args[]) {
        String str = "ABCDE/12345/一二三四五";
        System.out.println("Numbers:" + countNumber(str));      // Numbers:5
        System.out.println("Letters:" + countLetter(str));      // Letters:5
        System.out.println("Chinese:" + countChinese(str));     // Chinese:5
    }

    public static int countNumber(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    public static int countLetter(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    public static int countChinese(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }
}









        睡眠 / 暂停(单位: 毫秒):
        Thread.sleep(3000);   



        随机数:
        int min_number = 5000;
        int max_number = 9999;
        int Random_number = min_number + (int) (Math.random() * (max_number - min_number + 1000));     
        
        
        
        随机字符串:
        int length = 10;
        String str = "abcdefghijklm1no2pq3rs4tu5vw6xy7zA8BC9DE10FGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        System.out.println(sb.toString());


---------------------------------   截取字符串   ---------------------------------
    原字符: 123456789
    
        String strhours = String.valueOf(123456789);

        // 截取最后2位
        String aaa = strhours.substring(strhours.length() -2, strhours.length());   //截取
        >>> 89

        // 排除最后2位
        String bbb = strhours.substring(0,strhours.length()-2);   //截掉
        >>> 1234567








---------------------------------  分割字符串  ---------------------------------
        String str = "www-runoob-com";
        String[] temp;
        String delimeter = "-";  // 指定分割字符
        temp = str.split(delimeter); // 分割字符串
        // 普通 for 循环
        for(int i =0; i < temp.length ; i++){
            System.out.println(temp[i]);
            System.out.println("");
        }






---------------------------------   替换字符串   ---------------------------------

##########
//  "."是正则表达式的元字符，匹配除换行符以外的任意字符，所以replaceAll、replaceFirst才出现了这样的结果
    String s = "my.test.txt";
    System.out.println(s.replace(".", "#"));				// my#test#txt
    System.out.println(s.replaceAll(".", "#"));				// ###########
    System.out.println(s.replaceFirst(".", "#"));			// #y.test.txt
    System.out.println(s.replaceFirst("\\.", "#"));			// my#test.txt


###########
        String str = "“i’m, nana’s, ’ ‘at, ’ ‘as, foo  - ,  twice a, \"sadas\" ce of, ties, 123890 \\ ’";
        
        //可以在中括号内加上任何想要替换的字符 (数字也会被去掉)，实际上是一个正则表达式
        String regEx="[\n`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】‘；\\-：”“’。，\\\\ 、？0123456789\"]";
        
        String newString = str.replaceAll(regEx," ");    // 替换成 ' '
        System.out.println(newString);



##########
    相对比较简单 (推荐)
    直接用 replaceAll 删除非英文字母的字母:
        String temp = "";
        temp = str.replaceAll("[^a-zA-Z]", " ");
        System.out.println(temp);        


##########
        String str="123assume345contribute你好&*(){}&^%$#\n@@";

        //去除字符串中的数字
        System.out.println(" 去除字符串中的数字  " + str.replaceAll("\\d+"," "));

        //去除字符串中的字母和数字
        System.out.println(" 去除字符串中的字母和数字  " + str.replaceAll("[A-Za-z0-9]+"," "));

        String str1 = null;

        //去除字符串中的空格、回车、换行符、制表符
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        str1 = m.replaceAll("");
        System.out.println(" 去除字符串中的空格、回车、换行符、制表符  " + str1);  

```
</details>































<details>
<summary><b> 加减乘除 (不会损失精度 ) </b></summary>

```  

import java.math.BigDecimal;
public class AAA {
    public static void main(String args[]) throws Exception {


        // 如下所示: 浮点数运算会损失精度
        System.err.println("什么是 浮点数运算会损失精度 ? ");
        float f0 = 1.00f;
        float f1 = 0.99f;
        System.out.println("1 减去 0.99 等于 0.1, 然而实际运算结果却是:  "+ (f0 - f1) + "\n");

        String doubleValA = "1";
        String doubleValB = "0.99";

        System.out.println("add= " + add(doubleValA, doubleValB) + "\n" );                   // 加法
        System.out.println("sub= " + Subtracting(doubleValA, doubleValB )  + "\n" );         // 减法
        System.out.println("mul= " + Multiplied(doubleValA, doubleValB)  + "\n"  );          // 乘法
        System.out.println("div= " + Divided(doubleValA, doubleValB, 8)  + "\n"  );   // 除法

    }

    // add 加法
    public static double add(String doubleValA, String doubleValB) {
        System.out.println(" add 加法运算 , doubleValA : " + doubleValA + " , doubleValB : " + doubleValB);
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.add(b2).doubleValue();
    }

    // Subtracting 减法
    public static double Subtracting(String doubleValA, String doubleValB) {
        System.out.println("Subtracting 减法运算, doubleValA : " + doubleValA + " , doubleValB : " + doubleValB);
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.subtract(b2).doubleValue();
    }

    // Multiplied 乘以
    public static double Multiplied(String doubleValA, String doubleValB) {
        System.out.println("Multiplied 乘法运算, doubleValA : " + doubleValA + " , doubleValB : " + doubleValB);
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.multiply(b2).doubleValue();
    }

    // Divided 除以
    public static double Divided(String doubleValA, String doubleValB, int scale) {
        System.out.println("Divided 除法运算, doubleValA : " + doubleValA + " , doubleValB : " + doubleValB);
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}


```
</details>






























<details>
<summary><b>字符串之 : 正则表达式</b></summary>

```  

        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        String string = "asdf        www.52bbbb.com          Java2s com";
        Matcher matcher = pattern.matcher(string);
        if (matcher.find() == true) {
            System.out.println("GROUP 0:" + matcher.group(0));
        }else {
            System.out.println("noooooot Find !!!!! -_-!!!");
        }



        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);  // 不区分大小写
        String candidateString = "Java. java JAVA javA";
        Matcher matcher = p.matcher(candidateString);

        matcher.find(11);  // 起始位置,意思是从哪里开始找...
        System.out.println(matcher.group());
        System.out.println("------------- 1 -------------------");
        matcher.find();      // 接着上一个位置开始找
        System.out.println(matcher.group());
        System.out.println("--------------- 2 -----------------");





        // A group of 3 digits followed by 7 digits.
        String regex = "\\b(\\d{3})\\d{7}\\b";  // \\d匹配数字,{3}{7}加起来应该有10位数字

        // Compile the regular expression
        Pattern p = Pattern.compile(regex);
        String source = "1231234567 12345, and 9876543210";
        Matcher m = p.matcher(source);

        while (m.find()) {
            String phone = m.group(0);
            String areaCode = m.group(1);
            System.out.println("PhoneNumber is : " + phone + " Area  Code is :  " + areaCode);
        }
        输出结果:
        PhoneNumber is : 1231234567 Area  Code is :  123
        PhoneNumber is : 9876543210 Area  Code is :  987






        String regex = "(\\d{3})(\\d{3})(\\d{4})";
        Pattern p = Pattern.compile(regex);
        String source = "1234567890, 123456789,  and  9876543210";
        Matcher m = p.matcher(source);

        while(m.find()){
            System.out.println(m.group() + " - " + m.group(1) + " - " + m.group(2) + " - " + m.group(3));
        }

        输出:
            1234567890 - 123 - 456 - 7890
            9876543210 - 987 - 654 - 3210






小案例:  找出一段句子中所有的英文单词, 并循环遍历出来
        String regex = "[a-zA-Z]+"; 

        Pattern p = Pattern.compile(regex);
        String source = "123123 , 1. simple adj. 简单的 simply adv. 简单地 simplify vt. 简化   simplification n. 简单化";
        Matcher m = p.matcher(source);

        while (m.find()) {
            String aaa = m.group(0);
            System.out.println(aaa);
        }
    思考: 如果表达式是: [a-zA-Z] 会怎么样?        
    答案是:
        连续输出单个字母

        







    @Test
    public void Test() {
        String phonrNul = "我的电话号码是123456789 , 地方north of school , 我的另外一个号码是54321";
        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher(phonrNul);
        System.out.println(matcher);
        while(matcher.find()){
            System.out.println("lllllllllll:==>  " + matcher.group(0));
//            System.out.println("wwwwwwwwwww:{}" + matcher.group(1));
        }
    }        





        String inputLine = "Adams,John Quincy";
        Pattern r = Pattern.compile("(.*),(.*)");
        Matcher m = r.matcher(inputLine);
        if (!m.matches()) {
            throw new IllegalArgumentException("Bad Input");
        }
        // 分组0得到的是整个原字符串
        for (int i = 0; i < m.groupCount() + 1; i++) {
            System.out.println("分组" + i + ":" + m.group(i));
        }

        输出：
        分组0:Adams,John Quincy
        分组1:Adams
        分组2:John Quincy
        PS:
            匹配条件 换成 Pattern r = Pattern.compile(".*,.*"); 有新发现
            输出: 分组0:Adams,John Quincy        

```
</details>





























































<details>
<summary><b>  IO :  文件夹 / 文件 / 文件目录 </b></summary>

```  

    // 判断这个文件夹里面, 哪个是文件, 哪个是文件夹
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文 件： " + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }



文件路径中获取文件名:
        String file_Name =" G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";
        File tempFile =new File( file_Name.trim());
        String fileName = tempFile.getName();
        System.err.println("fileName = " + fileName);




删除文件:
    import java.io.File;

    try{
        File file = new File("C:\\Users\\SpringBoot\\IdeaProjects\\Study_English\\AAAAAAAAAAAAAAAA.txt");
        if(file.delete()){
            System.out.println(file.getName() + " 文件已被删除！");
        }else{
            System.out.println("文件删除失败！");
        }
    }catch(Exception e){
        e.printStackTrace();
    }


创建文件夹:
    File destFile = new File("C:\\Users\\SpringBoot\\IdeaProjects\\springboot\\src\\main\\java\\com\\how2java\\Uplwo123ller\\");
    destFile.mkdirs();

```
</details>





















<details>
<summary><b> IO : 读 / 写 </b></summary>

```  



import org.junit.Test;
import java.io.*;
public class IO {


    private String file_name = "test.txt";
    private String path = "src/main/java/com/hehe/Article/";
    private String file_path = path + file_name;
    

    /**
     *   推荐这种方式 ^_^
     *   读 文本文件
     */
    @Test
    public void test7(){
        /**
         来源 :  http://lvhongqiang.com/blog5.html
         我们都习惯于一次把文本的原始内容直接读取到内存中再做处理（暂时不考虑内存大小），这样做效率也会提高。
         很多人用readline()之类的方法，可能需要反复访问文件，
         而且每次readline()都会调用编码转换，降低了速度，
         所以，在已知编码的情况下，
         按字节流方式先将文件都读入内存，
         再一次性编码转换是最快的方式

         这种方法的好处是读取的内容可以彻底保持文件的原貌，
         而且速度应该是最快的，因为只需要调用一次文件访问，字符编码转换也只需要一次
         */

        File file = new File(file_path);

        Long filelength = file.length();     //获取文件长度

        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(filecontent));
    }








    /**
     * 读   -   字符流
     * 字符流FileReader主要用来读取字符的IO流，使用字符流读取文本文件可以解决乱码问题
     * 使用字符流拷贝文本文件可以避免文件中的内容乱码，需要注意的是字符流不能拷贝非文本文件，比如照片
        
       这种方式也不错:
         原因: 换行符正常导入 , 文本文件有换行符, 文本文件保持原样
         而且不会中文乱码...
     */
    @Test
    public void test8() {

        try (FileReader fr = new FileReader(file_path)) {
            int c;
            StringBuffer stringBuffer = new StringBuffer();
            //一次读取一个字符
            while ((c = fr.read()) != -1) {
                stringBuffer.append((char) c);
            }
            System.out.println(stringBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    /**
     *  读   -   按行读取文件
     */
    @Test
    public void READ_file() throws IOException {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("src/main/Java/TEST.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)        {
            System.out.println(str);
        }
        inputStream.close();
        bufferedReader.close();
    }







    /**
     *  写
     *  向文件中写入字符串  (会清空原来的文本内容)
     */
    @Test
    public void test5() throws IOException {

        File f=new File(file_path);
        OutputStream out =new FileOutputStream(f);
        String str="你好";
        byte[] b=str.getBytes();
        out.write(b);
        out.close();
    }





    /**
     * 写
     *  向文件中追加新内容
     *  支持中文
     */
    @Test
    public void test6() throws IOException {

        File f=new File(file_path);
        OutputStream out =new FileOutputStream(f,true);
        String str="大扎好, 我系渣渣辉.....";
        //String str="\r\nRollen";  可以换行
        byte[] b=str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }
}









==========================================   读取 txt文件 指定行   ==========================================
import java.io.*;
public class Read_Selected_Line{

    static String readLineVarFile(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = reader.readLine();
        if (lineNumber < 0 || lineNumber > getTotalLines(fileName)) {
            System.out.println("不在文件的行数范围之内。");
        }

        int num = 0;
        while (line != null) {
            if (lineNumber == ++num) {
//                System.out.println("line     " + lineNumber + ":     " + line);
                return line;
            }
            line = reader.readLine();
        }
        reader.close();
        return line;
    }

    // 文件内容的总行数。
    static int getTotalLines(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName)));
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static void main(String[] args) throws IOException {

        // 读取文件
        String fileName = "src/main/Java/西西里的美丽传说.txt";

        // 获取文件的内容的总行数
        int totalNo = getTotalLines(fileName);
        System.out.println("There are "+totalNo+ " lines in the text!");

        // 指定读取的行号
        int lineNumber = 7;

        //读取指定行的内容
        String line_string = readLineVarFile(fileName, lineNumber);
        System.out.println("line  :  " + lineNumber + " , 指定行数据 :  " + line_string);
    }
}





```
</details>



















































<details>
<summary><b>JDBC MySQL 增/删/改/查</b></summary>

```  
package com.swjtu;
import org.junit.Test;
import java.sql.*;
public class JDBC_test {
    private static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zzzzzuj7jk8ds36k8f95xw68k?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    
    // 增
    @Test
    public void Insert() throws SQLException {

        Connection conn = getConn();
        String sql = " insert into `user`(name , password) values(?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println(ps.toString());      // 输出 SQL 语句

        ps.setString(1, "aaa");
        ps.setInt(2, 6);
        
        int i = 0;
        try {
            i = ps.executeUpdate();
            if (i == 1){
                System.out.printf("添加了  %-12s  条数据   " , i);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            ps.close();                 // 记得关闭, 不然链接数量太大了就会报错
            conn.close();
            System.err.println("数据重复, 字段设置成了主键...");
        }
    }



    @Test
    public void test213(){
        //   -30  是间隔
        System.out.printf("%-30s  %s", "ABC", 123);
    }


    // 删
    @Test
    public void Delete() throws SQLException {
        Connection conn = getConn();
        String sql = "delete from user where username = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println(ps.toString());      // 输出 SQL 语句
        ps.setString(1,"aaa");
        int i = ps.executeUpdate();
        System.out.printf("成功删除  %-15s 条数据:", i);
        ps.close();
        conn.close();
    }


    // 改
    @Test
    public void Update() throws SQLException {

        Connection conn = getConn();
        Statement stmt = conn.createStatement();
        System.out.println(" 实例化Statement对象...");
        String sql = "           UPDATE `user` SET `username`=? WHERE `username`=?;               ";
        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println(ps.toString());      // 输出 SQL 语句
        ps.setString(1, "aaa");
        ps.setString(2, "bbb");

        int status = ps.executeUpdate();

        System.out.printf("成功更新  %-15s 条数据:", status);

        stmt.close();
        conn.close();
    }


    // 查
    @Test
    public void SELECT_ALL() throws SQLException {
        Connection conn = getConn();
        Statement stmt = conn.createStatement();
        System.out.println(" 实例化Statement对象...");

        String sql = "            SELECT * FROM `user`              ";
        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println(ps.toString());      // 输出 SQL 语句
        ResultSet rs = ps.executeQuery();

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.printf("%-30s %s  \n", username, password);
        }
        rs.close();
        stmt.close();
        conn.close();


        /*
        模糊查询: 必须这样写
        String aaa = "rest";
        String sql = "          select `phrase`,`chinese_meaning` from `phrase` where `phrase` LIKE ?              ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,  "%"+aaa+"%");
        System.out.println(ps.toString());      // 输出 SQL 语句
        ResultSet rs = ps.executeQuery();
        */
    }
}



/*

-- 删除数据库
drop database IF EXISTS `zzzzzuj7jk8ds36k8f95xw68k`;

-- 创建 数据库:
CREATE DATABASE IF NOT EXISTS `zzzzzuj7jk8ds36k8f95xw68k` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- 切换回
use `zzzzzuj7jk8ds36k8f95xw68k`;

-- 创建表
CREATE TABLE IF NOT EXISTS `user`(
`username` VARCHAR(100) ,
`password` VARCHAR(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 插入insert数据:
insert into user(username,password) values('HUAWEI','mate20');
insert into user(username,password) values('APPLE','IPHONE_5S');
insert into user(username,password) values('OPPO','R11');


 */

```
</details>




















































# 各种形式的转换
<details>
<summary><b> Java Array、List、Set互相转化 </b></summary>

```  


Array / Set
-----------------------------------------------------------------------------
Array -> Set
    String[] arr = {"AA","BB","DD","CC","BB"};
    Set<String> set = new HashSet<String>(Arrays.asList(arr));  

Set -> Array
	String[] arr = new String[set.size()]; 
    set.toArray(arr); 














List / Set:
-----------------------------------------------------------------------------

List -> Set
    Set<String> set = new HashSet<>(list);

Set -> List
    List<String> list_1 = new ArrayList<>(set);

被转换的List(Set)的修改不会对被转化后的Set（List）造成影响














数组( [] )    最高效；但是其容量固定且无法动态改变
ArrayList     容量可动态增长；但牺牲效率
当能确定长度并且数据类型一致的时候就可以用数组，其他时候使用ArrayList


List / Array
-----------------------------------------------------------------------------
List -> Array
    List<String> list = new ArrayList<String>();  
    list.add("AA");  
    list.add("BB");  
    list.add("CC");  
    Object[] objects = list.toArray();//返回Object数组  
    
    String[] arr = new String[list.size()];  
    list.toArray(arr);  //将转化后的数组放入已经创建好的对象中  


Array -> List
    String[] ss = {"JJ","KK"};  
    List<String> list1 = Arrays.asList(ss);  
    List<String> list2 = Arrays.asList("AAA","BBB");  


Array -> List
    String[] s = new String[]{"A", "B", "C", "D","E"};
    List<String> list = Arrays.asList(s);
    注意: 这里对s的修改，直接影响list 的数据
    s[0] ="AA";
    System.out.println("list: " + list);
    >>> list: [AA, B, C, D, E]

List -> Array
    String[] dest = list.toArray(new String[0]);//new String[0]是指定返回数组的类型
    System.out.println("dest: " + Arrays.toString(dest));
    >>>  [AA, B, C, D, E]
    注意这里的dest里面的元素不是list里面的元素，换句话就是说：对list中关于元素的修改，不会影响dest











Map / List / Set
-----------------------------------------------------------------------------
将 Map Key 转化为List
    List<String> mapKeyList = new ArrayList<String>(map.keySet());  

将 Map Key 转化为List
    List<String> mapValuesList = new ArrayList<String>(map.values());  

    将Map 的键转化为Set
        Set<String> mapKeySet = map.keySet();  
        
    将Map 的值转化为Set
        Set<String> mapValuesSet = new HashSet<String>(map.values());  




```
</details>

































<details>
<summary><b>字符串 / Array(数组) / Arraylist(列表) </b></summary>

```  


字符串转化成数组:
        String[] strarray="QQQQQQQQQQQQ".split("");//得到一个List数组
        System.out.println(strarray.length);




string 和 ArrayList 之间的转换:
-----------------------------------------------------------------------------
        //string 转 ArrayList
        List<String> strings_list = Arrays.asList("QWERTYUIOP".split(""));
        System.out.println(strings_list);
        >>> [Q, W, E, R, T, Y, U, I, O, P]


        //ArrayList 转 string
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);//[a, b, c]

        String list_str = StringUtils.join(list,",");
        System.out.println(list_str);//a,b,c        

     


```
</details>

































<details>
<summary><b>  unicode / ASCII码 / 编码转换 / ...  </b></summary>

```  


首先: 
    在 Windows 10 系统中回车换行 : \r\n


参考资料:      https://blog.csdn.net/u013066244/article/details/54708179


什么是 Unicode 编码?
\u6211\u8d70\u3002\u53bb\u90a3\u9065\u8fdc\u7684\u4ee5\u540e
这种的, 就是 Unicode 编码

更进一步讲,

可以理解为是：通用字符集

世界上存在着多种编码方式，同一个二进制数字可以被解释成不同的符号。
因此，要想打开一个文本文件，就必须知道它的编码方式，否则用错误的编码方式解读，就会出现乱码。
为什么电子邮件常常出现乱码？就是因为发信人和收信人使用的编码方式不一样。
可以想象，如果有一种编码，将世界上所有的符号都纳入其中。每一个符号都给予一个独一无二的编码，那么乱码问题就会消失。这就是Unicode，
就像它的名字都表示的，这是一种所有符号的编码。
Unicode当然是一个很大的集合，现在的规模可以容纳100多万个符号。
每个符号的编码都不一样，
比如，U+0639表示阿拉伯字母Ain，U+0041表示英语的大写字母A，U+4E25表示汉字”严”。
具体的符号对应表，可以查询  http://www.chi2ko.com/tool/CJK.htm


但是呢！Unicode只是一个符号集，它和ASCII是同一级别的。它没有规定如何存储
带来的问题是：如何才能区别Unicode和ASCII？

带来结果：出现了Unicode的多种存储方式，也就是说有许多种不同的二进制格式，可以用来表示Unicode

UTF-8
互联网的普及，强烈要求出现一种统一的编码方式。UTF-8就是在互联网上使用最广的一种Unicode的实现方式。
其他实现方式还包括UTF-16（字符用两个字节或四个字节表示）和UTF-32（字符用四个字节表示），不过在互联网上基本不用。

重复一遍，
这里的关系是，UTF-8是Unicode的实现方式之一

UTF-8最大的一个特点，就是它是一种变长的编码方式。
它可以使用1~4个字节表示一个符号，根据不同的符号而变化字节长度。

UTF-8的编码规则很简单，只有二条：

1）对于单字节的符号，字节的第一位设为0，后面7位为这个符号的unicode码。因此对于英语字母，UTF-8编码和ASCII码是相同的。

2）对于n字节的符号（n>1），第一个字节的前n位都设为1，第n+1位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。

参考来源:  http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html



说了那么多, 接下来赶紧说说怎么用 Java 语言, 实现 Unicode 转成 中文呢?
直接上代码:
import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeToString{
    @Test
    public void UnicodeTo_chinese(){
        String str = "\\u5e26\\u6211\\u8d70\\u3002\\u53bb\\u90a3\\u9065\\u8fdc\\u7684\\u4ee5\\u540e";

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);

        char ch;

        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch+"" );
            System.out.println(str);
        }
    }
}







-------------------   unicode   ----------------------------------------------------------------------------

在线 Unicode 转换 :   https://tool.73ic.com/tool/tool_unicodeascii.html


字符串 和 unicode 之间的转换:
public class unicode_string {

    /*
     * 字符串 -> unicode
     */
    public static String string_to_Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }


    /*
     * unicode -> 字符串
     */
    public static String unicode_to_String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }


    public static void main(String[] args) {
        String test = "我叫A12";
        String unicode = string_to_Unicode(test);
        String string = unicode_to_String(unicode) ;
        System.out.println(unicode);
        System.out.println(string);
    }
}





Unicode:
中文 Unicode 对照表:  http://www.chi2ko.com/tool/CJK.htm
我		6211
哈		54C8
不		4E0D

英文 Unicode 预览:
参考资料: https://zh.wikipedia.org/wiki/Unicode%E5%AD%97%E7%AC%A6%E5%88%97%E8%A1%A8
A(拉丁字母A)    U+0041	 	\u41
a(拉丁字母a)    U+0061		\u61
=(等于号)	   U+003D		\u3d
+(加号)         U+002B 		\u2b
 空格           U+0020      \u20
\(反斜杠)       U+005C      \u5c
n(拉丁字母n)    U+006E      \u6e


现在我们用Java转换输出: 
													  \    n        
System.out.println(string_to_Unicode("\\n"));    ->  \u5c\u6e

                                                     回车
System.out.println(string_to_Unicode("\n"));	 ->  \ua

                                                      \
System.out.println(string_to_Unicode("\\"));	 ->  \u5c

                                                       n
System.out.println(string_to_Unicode("n"));		 ->  \u6e


测试:
现有文本文件 : TEST.txt , 内容是:
A
A

打印出来的 Unicode 是这样的:
\u41\ud\ua\u41

其中 A 的Unicode码是 \u41
那么: \ud\ua  就是Windows系统中文本文件的换行了



关于 Unicode 中的回车/换行:
结论:
    在 Windows 系统下, 
    \ud\ua  就是文本文件的换行


在线 Unicode 转换 :   https://tool.73ic.com/tool/tool_unicodeascii.html
\u7136\ud\ua\u45\u76\u65\u72\u79\u74\u68\u69\u6e\u67\u20\u74\u68\u61\u74\u20\u63\u6f\u6d\u65\u73\u20\u66\u72\u6f\u6d\u20\u74\u68\u65\u20\u65\u61\u72\u74\u68\u20\u65\u76\u65\u6e\u74\u75\u61\u6c\u6c\u79\u20\u72\u65\u74\u75\u72\u6e\u73\u2e\ud\ua\ud\ua\ud\ua\ud\ua\u5373\u4f7f\u34\u30\u5428\u7684\u5b89\u901a\u7eb3\u31\u32\u578b\u8d27\u673a\u4e5f\u4e00\u6837\ud\ua\u45




















-------------------   ASCII 码  ----------------------------------------------------------------------------
常用 ASCII 码:
A 				65
B   			66
C  				67
CR(回车) 		13
LF(换行) 		10
DLE(空格)		16
?				63
=				61
+				43

来源:  https://tool.oschina.net/commons?type=4


public class dasdasdasd {
    public static void main(String[] args) {
        System.out.println(stringToAscii("A"));             //  65
        System.out.println(asciiToString("65"));            //  A
    }


    /*
     * 字符串 -> Ascii
     */
    public static String stringToAscii(String value){
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }


    /*
     * Ascii -> 字符串
     */
    public static String asciiToString(String value)    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

}




测试:
现有文本文件 : TEST.txt , 内容是:
A
A

打印出来的 ASCII 码 是这样的:
65,13,10,65
其中 A 的ASCII码是  65
那么: 13 10  就是Windows系统中文本文件的换行了


关于 ASCII 码 中的回车/换行:
结论:
    在 Windows 系统下, 
    13 10  就是文本文件的换行





```
</details>








































<details>
<summary><b>集合 与 json 之间的转换</b></summary>

```  

教程来源:  http://www.51gjie.com/java/790.html
          http://www.gogoomo.com/2017/11/16/4%E7%A7%8D%E6%96%B9%E6%B3%95%E5%B0%86String%E8%BD%AC%E4%B8%BAJSON/
          https://juejin.im/post/5dbd59a3f265da4d56090fc9

首先: 先要

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.5</version>
    </dependency>

    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.51</version>
    </dependency>


    

然后, 建一个实体类 User:
class User {
    private String name;
    private Integer age;
    private String address;
    public User(){

    }
    public User(String name, Integer age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}



然后就可以转换了...

    @Test
    public void Map_to_JSON(){
    }


    @Test
    public void JSON_to_map(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //JSON转map
            String mapJson = "{\"one\":{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"}," + "\"two\":{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"}," + "\"three\":{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}}";
            JavaType javaType2 = objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class, User.class);
            Map < String,User > userMap = (Map < String, User > ) objectMapper.readValue(mapJson, javaType2);
            User one = userMap.get("one");
            User two = userMap.get("two");
            User three = userMap.get("three");
            System.out.println(one.getName() + "\t" + one.getAge() + "\t" + one.getAddress());
            System.out.println(two.getName() + "\t" + two.getAge() + "\t" + two.getAddress());
            System.out.println(three.getName() + "\t" + three.getAge() + "\t" + three.getAddress());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void JSON_to_list(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //JSON转list
            String listJson = "[{\"name\":\"张三\",\"age\":21,\"address\":\"深圳\"}," + "{\"name\":\"李四\",\"age\":11,\"address\":\"武汉\"}," + "{\"name\":\"王五\",\"age\":31,\"address\":\"北京\"}]";
            JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
            List< User > userList = (List < User > ) objectMapper.readValue(listJson, javaType1);
            for (User user1: userList) {
                System.out.println(user1.getName() + "\t" + user1.getAge() + "\t" + user1.getAddress());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }








===============================   使用 阿里巴巴的 FastJson   ==============================

    List< String > list = new ArrayList< String >();
    list.add("AAA");
    list.add("123");
    list.add("@#&&&&&&&&");

    
    // List -> json
    String json_str= JSON.toJSON(list).toString();
    System.err.println(json_str);

    //json -> list(严格来讲并不是真正意义的list)
    JSONArray list2 = parseArray(json_str);
    for (int i = 0; i < list2.size(); i++) {
        System.err.println(list2.get(i));
    }    











        //2.1 将List<Person> 转成 json  ( 使用 fastjson )
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(10, "张三"));
        personList.add(new Person(10, "李四"));
        personList.add(new Person(10, "王五"));
        Object obj2 = JSONArray.toJSON(personList);
        String json2 = obj2.toString();
        System.out.println("将List<Person>转成json:" + json2);


    // json 转成 Java对象 (方法一)
    @Test
    public void JSON_to_JavaObject(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String json = "{\"name\":\"张三\",\"age\":23,\"address\":\"深圳市\"}";
            User zhang = objectMapper.readValue(json, User.class);
            System.out.println(zhang.getName() + "\n" + zhang.getAge() + "\n" + zhang.getAddress());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    // json 转成 Java对象 (方法二: Gson 实现 )
    @Test
    public void JSONstring_to_JavaObject(){
        String jsonString = " {\"name\":\"YXB\",\"age\":23,\"address\":\"北京\"} ";
        Gson g = new Gson();
        User  user = g.fromJson(jsonString, User.class);
        System.out.println(user.toString());
    }



    // Java 对象 转成 JSON ( 使用 Alibaba 的 fastjson )
    Person p = new Person(10, "张三");
    Object obj = JSONArray.toJSON(p);
    String json = obj.toString();
    System.out.println("将Person对象转成json:" + json);

    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.51</version>
    </dependency>




    // 将Map 转成 json字符串  方式一
    @Test
    public void Map_to_json_String() throws Exception {
        //创建Map集合对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",20);
        map.put("gender","男");
        //2、创建sackson核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3、将对象转换为json字符串
        String json = mapper.writeValueAsString(map);
        System.out.println(json);  //{"name":"李四","age":21,"gender":"女","birthday":1572521699055}
    }


    // 将Map 转成 json字符串  方式二 ( 使用 Alibaba 的 fastjson )
        Map<String, Person> map = new HashMap<>();
        map.put("1", new Person(10, "张三"));
        map.put("2", new Person(10, "李四"));
        map.put("3", new Person(10, "王五"));
        Object obj3 = JSONArray.toJSON(map);
        String json3 = obj3.toString();
        System.out.println("将Map<String,Person>转成json:" + json3);



```
</details>













































# 集合
<details>
<summary><b> 集合[ArrayList(列表), Set, Map]  /  Array(数组)  简介  :</b></summary>

```  



Map:
    是集合的一部分，但与Collection是相互独立的，没有任何关系
    Map中都是以key-value的形式存在，
    其中key必须唯一，
    主要有HashMap、HashTable、TreeMap三个实现类
    
    TreeMap:
        是一个有序的key-value集合，它是通过红黑树实现的
    
    Hashtable:
        Key、Value均不能为null
        HashTable已经被淘汰了，不要在代码中再使用它
        以下描述来自于HashTable的类注释:
            If a thread-safe implementation is not needed, 
            it is recommended to use HashMap in place of Hashtable.
            If a thread-safe highly-concurrent implementation is desired, 
            then it is recommended to use java.util.concurrent.ConcurrentHashMap in place of Hashtable.
        翻译:
            如果不需要线程安全实现，建议使用HashMap代替Hashtable。
            如果需要线程安全的高并发实现，那么建议使用 java.util.concurrent.ConcurrentHashMap 代替 Hashtable



    HashMap:
        Key、Value 可以为 null (可以允许存在一个为null的key , 任意个为 null 的 value)
          



Collection 主要有三个子接口,分别为:
    1 List(列表) 
    2 Set(集)
    3 Queue(队列)

    List、Queue:
        元素有序可重复，
        List中主要有ArrayList、LinkedList两个实现类: 

    Set:
        元素无序不可重复
        Set中则是有HashSet实现类；

而Queue是在JDK1.5后才出现的新集合，主要以数组和链表两种形式存在


 ArrayList：底层的数据结构使用的是数组结构（数组长度是可变的百分之五十延长）（特点是查询很快，但增删较慢）线程不同步
 LinkedList：底层的数据结构是链表结构（特点是查询较慢，增删较快）








 数组(Array)和列表(ArrayList)有什么区别?
    
    数组(Array):
        Array：它是数组，元素类型和数组的大小都是确定的, 
        申明数组的时候就要初始化并确定长度，长度不可变，而且它只能存储同一类型的数据，
        比如申明为String类型的数组，那么它只能存储String类型数据
    
    ArrayList(集合):
        它是一个集合，需要先申明，然后再添加数据，长度是根据内容的多少而改变的，
        ArrayList可以存放不同类型的数据
        ArrayList的元素类型不能是基本类型 , 比如你 不能 这样初始化一个ArrayList:
            List<int> list=new ArrayList<int>();//会报错的！

    获取长度
        数组：length属性
        ArrayList：size()方法

    增加元素
        数组：直接通过序号赋值。 eg：array[0]=233;
        ArrayList：通过add方法。eg：list.add(0,233);

    删除元素:
        arraylist: 
            list.remove(str);
        数组:
            java的api中，并没有提供删除数组中元素的方法
            虽然数组是一个对象，不过并没有提供add()、remove()或查找元素的方法
            这就是为什么类似ArrayList和HashSet受欢迎的原因
    
    
    创建 ArrayList对象不用指定长度，而创建数组对象必须指定长度
    数组可以是多维的，而ArrayList不是
    ArrayList可以扩容，而数组不能

    总结 : 
        数组( [] )    最高效；但是其容量固定且无法动态改变
        ArrayList     容量可动态增长；但牺牲效率
        当能确定长度并且数据类型一致的时候就可以用数组，其他时候使用ArrayList




```
</details>
























<details>
<summary><b> 数组 Array [] </b></summary>

```  


基本语法:
下面是这两种语法的代码示例：
double[] myList;         // 首选的方法
或
double myList[];         //  效果相同，但不是首选方法

数组的元素是通过索引访问的。数组索引从 0 开始



获取长度
    数组：length属性
    ArrayList：size()方法

增加元素
    数组：直接通过序号赋值。 eg：array[0]=233;
    ArrayList：通过add方法。eg：list.add(0,233);

删除元素:
    arraylist: 
        list.remove(str);
    数组:
        java的api中，并没有提供删除数组中元素的方法
        虽然数组是一个对象，不过并没有提供add()、remove()或查找元素的方法
        这就是为什么类似ArrayList和HashSet受欢迎的原因




// 数组大小
      int size = 10;
// 定义数组
      double[] myList = new double[size];
      myList[0] = 5.6;
      myList[1] = 4.5;
      myList[2] = 3.3;
      ...



    double[] myList = {1.9, 2.9, 3.4, 3.5};
 
      // 打印所有数组元素
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      
      // 计算所有元素的总和
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      
      // 查找最大元素
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Max is " + max);



      double[] myList = {1.9, 2.9, 3.4, 3.5}; 
      // 打印所有数组元素
      for (double element: myList) {
         System.out.println(element);
      }


```
</details>






















<details>
<summary><b>Collection : List </b></summary>

```  


更加详细的教程: http://www.51gjie.com/java/299.html


void add(String item)  //依次往后添加添加元素
void add(String item, int index) //在指定位置处添加元素
void remove(int position) //删除第几个元素（索引从0开始）
void remove(String item) //删除相同的元素
void removeAll() //删除所有元素




Arraylist 并没有直接提供删除某个元素的 API:
需要自己实现:
ArrayList删除特定不同元素的2种方法:
    1. 使用下标的方式删除
    ArrayList al = new ArrayList();
    al.add("a");
    al.add("b");
    al.add("b"); 
    al.add("c"); 
    for (int i = 0; i < al.size(); i++) {
        if (al.get(i) == "b") {
            al.remove(i);
            i--;//一定要移动下标，不然会报错
        }
    }	
    解析:
        在代码中，删除元素后，需要把下标减一。
        这是因为在每次删除元素后，ArrayList会将后面部分的元素依次往上挪一个位置(就是copy)，
        所以，下一个需要访问的下标还是当前下标，所以必须得减一才能把所有元素都遍历完


    2. 使用Iterator元素遍历的方式删除
    Iterator<String> sListIterator = list.iterator();  
    while(sListIterator.hasNext()){  
        String e = sListIterator.next();  
        if(e.equals("3")){  
        sListIterator.remove();  
        }  
    }





list 之间不能直接相加, 必须这样借助第三方
      ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        list1.add("aaa");
        list2.add("aaa");

        list3.addAll(list1);
        list3.addAll(list2);

        输出:  [aaa, aaa]




        ArrayList<String> list = new ArrayList<String>();
        list.add("000");
        list.add("111");
        list.add("222");
        System.out.println(list.indexOf("222"));     // 2 (如果不存在 , 返回 -1)




ArrayList类
		List list = new ArrayList();

		// 向列表的尾部追加指定的元素
		list.add("lwc");

		// 在列表的指定位置插入指定元素
		list.add(1, "nxj");

		// 追加指定 collection 中的所有元素到此列表的结尾
		list.addAll(new ArrayList());

		// 从列表中移除所有元素
		list.clear();

		// 如果列表包含指定的元素,则返回true
		list.contains("nxj");

		// 如果列表包含指定 collection 的所有元素,则返回 true
		list.containsAll(new ArrayList());

		// 比较指定的对象与列表是否相等
		list.equals(new ArrayList());

		// 返回列表中指定位置的元素
		list.get(0);

		// 返回列表的哈希码值
		list.hashCode();

		// 返回列表中首次出现指定元素的索引,如果列表不包含此元素,则返回 -1
		list.indexOf("lwc");

		// 返回列表中最后出现指定元素的索引,如果列表不包含此元素,则返回 -1
		list.lastIndexOf("lwc");

		// 如果列表不包含元素,则返回 true
		list.isEmpty();

		// 移除列表中指定位置的元素
		list.remove(0);

		// 移除列表中出现的首个指定元素
		list.remove("lwc");

		// 从列表中移除指定 collection 中包含的所有元素
		list.removeAll(new ArrayList());

		// 用指定元素替换列表中指定位置的元素
		list.set(0, "lp");

		// 返回列表中的元素数
		list.size();

		// 返回列表中指定的fromIndex(包括)和toIndex(不包括)之间的部分视图
		list.subList(1, 2);

		// 返回以正确顺序包含列表中的所有元素的数组
		list.toArray();

		// 返回以正确顺序包含列表中所有元素的数组
		list.toArray(new String[] { "a", "b" });




LinkedList类
add(E e): 将指定元素添加到此列表的结尾。
add(int index, E element)：在此列表中指定的位置插入指定的元素
addAll(int index, Collection<? extends E> c)：将指定 collection 中的所有元素从指定位置开始插入此列表。
AddFirst(E e): 将指定元素插入此列表的开头
addAll(Collection<? extends E> c)：添加指定 collection 中的所有元素到此列表的结尾 顺序是指定 collection 的迭代器返回这些元素的顺序。
addLast(E e): 将指定元素添加到此列表的结尾。
clear()： 从此列表中移除所有元素。
remove()：获取并移除此列表的头（第一个元素）。
remove(int index)：移除此列表中指定位置处的元素。
remove(Objec o)：从此列表中移除首次出现的指定元素（如果存在）。
removeFirst()：移除并返回此列表的第一个元素。
removeFirstOccurrence(Object o)：从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。
removeLast()：移除并返回此列表的最后一个元素。
removeLastOccurrence(Object o)：从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）。
get(int index)：返回此列表中指定位置处的元素。
getFirst()：返回此列表的第一个元素。
getLast()：返回此列表的最后一个元素。
indexOf(Object o)：返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
lastIndexOf(Object o)：返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。



------------------------------  迭代遍历  ------------------------------

List的四种遍历方式:
        //方法1 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        Iterator it1 = list.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //方法2 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        for(Iterator it2 = list.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }

        //方法3 增强型for循环遍历
        for(String value:list){
            System.out.println(value);
        }

        //方法4 一般型for循环遍历
        for(int i = 0;i < list.size(); i ++){
            System.out.println(list.get(i));
        }





```
</details>




































<details>
<summary><b> Collection : Set </b></summary>

```  



注意:
    Set<String> set = new Set<String>();           // 错误
    Set<String> hashSet = new HashSet<String>();   // 正确

Set 区分大小写, 也就是 aaa 与 AAA 是两个不同的字符串 , 所以都会存进去

    Set<String> hashSet = new HashSet<String>();   // 正确
    hashSet.add("aaa");
    hashSet.add("AAA");
    输出: [aaa, AAA]



Set类 - 不会存储重复的元素。加入Set的每个元素必须是唯一的，否则，Set是不会把它加进去的
boolean add(Object o)：该方法用于向集合里添加一个元素。
boolean addAll(Collection c)：该方法把集合c里的所有元素添加到指定集合里。
void clear()：清除集合里的所有元素，将集合长度变为0。
boolean contains(Object o)：返回集合里是否包含指定元素。
boolean containsAll(Collection c)：返回集合里是否包含集合c里的所有元素。
boolean isEmpty()：返回集合是否为空。当集合长度为0时返回true，否则返回false。
Iterator iterator()：返回一个Iterator对象，用于遍历集合里的元素。
boolean remove(Object o)：删除集合中的指定元素o，当集合中包含了一个或多个元素o时，这些元素将被删除，该方法将返回true。
boolean removeAll(Collection c)：将集合中删除集合c里包含的所有元素（相当于用调用该方法的集合减集合c），如果删除了一个或一个以上的元素，则该方法返回true







TreeSet类 - 使用元素的自然顺序对元素进行排序
E ceiling(E e) 
  返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。 
Comparator<? super E> comparator() 
  返回对此 set 中的元素进行排序的比较器；如果此 set 使用其元素的自然顺序，则返回 null。 
Iterator<E> descendingIterator() 
  返回在此 set 元素上按降序进行迭代的迭代器。 
NavigableSet<E> descendingSet() 
  返回此 set 中所包含元素的逆序视图。 
E first() 
  返回此 set 中当前第一个（最低）元素。 
E floor(E e) 
  返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。 
SortedSet<E> headSet(E toElement) 
  返回此 set 的部分视图，其元素严格小于 toElement。 
NavigableSet<E> headSet(E toElement, boolean inclusive) 
  返回此 set 的部分视图，其元素小于（或等于，如果 inclusive 为 true）toElement。 
E higher(E e) 
  返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。 
Iterator<E> iterator() 
  返回在此 set 中的元素上按升序进行迭代的迭代器。 
E last() 
  返回此 set 中当前最后一个（最高）元素。 
E lower(E e) 
  返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。 
E pollFirst() 
  获取并移除第一个（最低）元素；如果此 set 为空，则返回 null。 
E pollLast() 
  获取并移除最后一个（最高）元素；如果此 set 为空，则返回 null。 
NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) 
  返回此 set 的部分视图，其元素范围从 fromElement 到 toElement。 
SortedSet<E> subSet(E fromElement, E toElement) 
  返回此 set 的部分视图，其元素从 fromElement（包括）到 toElement（不包括）。 
SortedSet<E> tailSet(E fromElement) 
  返回此 set 的部分视图，其元素大于等于 fromElement。 
NavigableSet<E> tailSet(E fromElement, boolean inclusive) 
  返回此 set 的部分视图，其元素大于（或等于，如果 inclusive 为 true）fromElement。 







HashSet类 
不能重复存放
t不能保证元素的排列顺序，顺序可能与添加顺序不同，顺序也有可能发生变化

1.equals()方法 
用来实现Set中元素的不重复性，如果不覆盖（override）equals()方法，默认使用父类Object的equals方法，则只是比较对象的引用是否相同。
2.hashCode() 
hashCode()方法时为了实现HashSet和LinkedHashSet而实现的。只有知道对象的hash值，才能根据这个hash值确定 存放在散列表的槽的index。同样，如果不覆盖（override）hashCode()方法，默认使用父类Object的hashCode()方法。
3.toString()方法 
toString()方法在打印对象时会调用。如果不覆盖（override）toString()方法，默认使用父类Object的。
4.compareTo()方法 
用户类要实现Comparable接口。这个方法主要用于将对象存放在TreeSet()时保证顺序的。由于是接口，所以用户类必须要实现这个方法。 



------------------------------  迭代遍历  ------------------------------

set的三种遍历方式:        
        //方法1 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        Iterator it1 = set.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //方法2 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
        for(Iterator it2 = set.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }

        //方法3 增强型for循环遍历
        for(String value: set){
            System.out.println(value);
        }





```
</details>




















<details>
<summary><b>Map (TreeMap Hashtable HashMap)</b></summary>

```  



===================================    HashMap   ===================================

void                 clear()                              清空, 没有返回值
Object               clone()                              克隆(复制?)
boolean              containsKey(Object key)              包含某个键
boolean              containsValue(Object value)          包含某个值
Set<Map.Entry<K,V>>  entrySet()                           返回一个包含HashMap的键值对的set
V                    get(Object key)                      根据键获取值, 没有返回值
boolean              isEmpty()                            是否为空, 返回值 bool 类型
Set<K>               keySet()                             返回一个HashMap键的Set
V                    put(K key, V value)                  添加 , 没有返回值
void                 putAll(Map<? extends K,? extends V> m)
V                    remove(Object key)                   根据键移除, 没有返回值
int                  size()                               大小, 返回值是 int 类型
Collection<V>        values()                             返回一个HashMap的值的Collection













===================================    HashTable   ===================================
ps:
    HashTable已经被淘汰了，不要在代码中再使用它













===================================    TreeMap   ===================================

资料:   https://www.jianshu.com/p/2dcff3634326

在Map集合框架中，除了HashMap以外, TreeMap 也是我们工作中常用到的集合对象之一,
优点:
    支持排序
        与HashMap相比，TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序


TreeMap基本操作( 增 遍历 key value 获取元素 删除元素 判断元素 ):
import java.util.*;
public class TreeMap_Test {
    public static void main(String[] agrs){
        //创建TreeMap对象：
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        System.out.println("初始化后,TreeMap元素个数为：" + treeMap.size());

        //新增元素:
        treeMap.put("hello",1);
        treeMap.put("world",2);
        treeMap.put("my",3);
        treeMap.put("name",4);
        treeMap.put("is",5);
        treeMap.put("jiaboyan",6);
        treeMap.put("i",6);
        treeMap.put("am",6);
        treeMap.put("a",6);
        treeMap.put("developer",6);
        System.out.println("添加元素后,TreeMap元素个数为：" + treeMap.size());

        //遍历元素：
        Set<Map.Entry<String,Integer>> entrySet = treeMap.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("TreeMap元素的key:"+key+",value:"+value);
        }

        //获取所有的key：
        Set<String> keySet = treeMap.keySet();
        for(String strKey:keySet){
            System.out.println("TreeMap集合中的key:"+strKey);
        }

        //获取所有的value:
        Collection<Integer> valueList = treeMap.values();
        for(Integer intValue:valueList){
            System.out.println("TreeMap集合中的value:" + intValue);
        }

        //获取元素：
        Integer getValue = treeMap.get("jiaboyan");//获取集合内元素key为"jiaboyan"的值
        String firstKey = treeMap.firstKey();//获取集合内第一个元素
        String lastKey =treeMap.lastKey();//获取集合内最后一个元素
        String lowerKey =treeMap.lowerKey("jiaboyan");//获取集合内的key小于"jiaboyan"的key
        String ceilingKey =treeMap.ceilingKey("jiaboyan");//获取集合内的key大于等于"jiaboyan"的key
        SortedMap<String,Integer> sortedMap =treeMap.subMap("a","my");//获取集合的key从"a"到"jiaboyan"的元素

        //删除元素：
        Integer removeValue = treeMap.remove("jiaboyan");//删除集合中key为"jiaboyan"的元素
        treeMap.clear(); //清空集合元素：

        //判断方法：
        boolean isEmpty = treeMap.isEmpty();//判断集合是否为空
        boolean isContain = treeMap.containsKey("jiaboyan");//判断集合的key中是否包含"jiaboyan"
    }
}




TreeMap 排序:
import java.util.*;
class SortedTest implements Comparable<SortedTest> {
    private int age;
    public SortedTest(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //自定义对象，实现compareTo(T o)方法：
    public int compareTo(SortedTest sortedTest) {
        int num = this.age - sortedTest.getAge();
        //为0时候，两者相同：
        if(num==0){
            return 0;
            //大于0时，传入的参数小：
        }else if(num>0){
            return 1;
            //小于0时，传入的参数大：
        }else{
            return -1;
        }
    }
}

 class TreeMapTest {

    public static void main(String[] agrs){
        //自然顺序比较
        naturalSort();
    }


    //自然排序顺序：
    public static void naturalSort(){
        //第一种情况：Integer对象
        TreeMap<Integer,String> treeMapFirst = new TreeMap<Integer, String>();
        treeMapFirst.put(1,"jiaboyan");
        treeMapFirst.put(6,"jiaboyan");
        treeMapFirst.put(3,"jiaboyan");
        treeMapFirst.put(10,"jiaboyan");
        treeMapFirst.put(7,"jiaboyan");
        treeMapFirst.put(13,"jiaboyan");
        System.out.println(treeMapFirst.toString());

        //第二种情况:SortedTest对象
        TreeMap<SortedTest,String> treeMapSecond = new TreeMap<SortedTest, String>();
        treeMapSecond.put(new SortedTest(10),"jiaboyan");
        treeMapSecond.put(new SortedTest(1),"jiaboyan");
        treeMapSecond.put(new SortedTest(13),"jiaboyan");
        treeMapSecond.put(new SortedTest(4),"jiaboyan");
        treeMapSecond.put(new SortedTest(0),"jiaboyan");
        treeMapSecond.put(new SortedTest(9),"jiaboyan");
        System.out.println(treeMapSecond.toString());
    }
}

















map的四种遍历方式:
---------------------------------------------------------------------------------------
        //方法一: 用entrySet()  
        //返回的 set 中的每个元素都是一个 Map.Entry 类型。
        // 推荐，尤其是容量大时
        Iterator it1 = map.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry m=(Map.Entry)it1.next();
            System.out.println("[name = " + m.getKey() 
                + "] age = " + m.getValue());
        }


        // 方法二：jdk1.5支持，用entrySet()和For-Each循环()
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("[name = " + m.getKey() + "] age = " + m.getValue());
        }


        // 方法三：用keySet() 普遍使用，二次取值
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()){
            String key = (String) it2.next();
            System.out.println("[name = " + key 
                + "] age = " + map.get(key) );
        }


        // 方法四：jdk1.5支持，用keySEt()和For-Each循环
        for(Object key: map.keySet()){
            System.out.println("[name = " + key 
                + "] age = " + map.get(key) );
        }





```
</details>


























<details>
<summary><b> List / Set 的 交集 / 差集</b></summary>

```  


Java List的并集 交集 差集 去重复并集
public static void main(String[] args) {
    List<String> list1 = new ArrayList<String>();
    list1.add("A");
    list1.add("B");
    list1.add("C");

    List<String> list2 = new ArrayList<String>();
    list2.add("C");
    list2.add("B");
    list2.add("D");
    
    // 并集
    list1.addAll(list2);
    System.out.println(list1);          // [A, B, C, C, B, D]
    
    // 去重复并集
    list2.removeAll(list1);
    list1.addAll(list2);
    System.out.println(list1);          // [A, B, C, D]

    // 交集
    // 求交集时候, list1 必须是小集合(容量小的集合) , list2是容量大的集合
    list1.retainAll(list2);
    System.out.println(list1);          // [B, C]

    // 差集
    list1.removeAll(list2);
    System.out.println(list1);          // [A]
}







java集合的交集，并集，差集:
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        //  交集
        set1.retainAll(set2);
        System.out.println("交集是 "+set1);

        //  并集
        set1.addAll(set2);

        //  差集
        set1.removeAll(set2);


```
</details>







































# Java 小工具
<details>
<summary><b>批量重命名文件</b></summary>

```  


简易版:
import java.io.File;
public class Rename_file {
    public static void main(String[] args) {
        renameFiles("C:\\Users\\SpringBoot\\IdeaProjects\\Java_Tools\\src\\main\\Java\\Tools_6\\TXT\\","Novel_" , ".txt");
        System.out.println("执行完成");
    }

    /**
     * dirPath  文件加路径      比如: C:\Users\SpringBoot\IdeaProjects\Java_Tools\src\main\Java\Tools_6\TXT\
     * prefix   文件名         比如: xxx
     * Suffix   文件后缀       比如: .Java
     */
    public static void renameFiles(String dirPath,String prefix , String Suffix){
        File file=new File(dirPath);
        if(!file.isDirectory()){
            return;
        }
        File files[]=file.listFiles();
        int index=1;

        for(File f:files){
            File newFile=new File(dirPath,prefix+String.valueOf(index++) + Suffix);
            f.renameTo(newFile);
        }
    }
}






命令行输入版:
import java.io.File;
import java.util.Scanner;
public class Rename_file {
    public static void main(String[] args) {

        String file_path = "";
        String prefix = "";
        String Suffix = "";

        Scanner scan_file_path = new Scanner(System.in);
        // 从键盘接收数据
        // nextLine方式接收字符串
        System.err.println("----------------------------   请输入文件夹路径:  ");
        // 判断是否还有输入
        if (scan_file_path.hasNextLine()) {
            file_path = scan_file_path.nextLine();
//            System.out.println("文件夹路径为:  " + file_path);
        }


        Scanner scan_prefix = new Scanner(System.in);
        System.err.println("----------------------------    请输入你要命名的名字的前缀 :  ");
        // 判断是否还有输入
        if (scan_prefix.hasNextLine()) {
            prefix = scan_prefix.nextLine();
//            System.out.println(prefix);
        }


        Scanner scan_Suffix = new Scanner(System.in);
        System.err.println("----------------------------   请输入文件的后缀 :  ");
        // 判断是否还有输入
        if (scan_Suffix.hasNextLine()) {
            Suffix = scan_Suffix.nextLine();
//            System.out.println(Suffix);
        }


        scan_file_path.close();
        scan_prefix.close();
        scan_Suffix.close();

        //                    Novel_     .txt
        renameFiles(file_path,prefix , Suffix);
        System.out.println("执行完成");
    }

    /**
     * dirPath  文件加路径      比如: C:\Users\SpringBoot\IdeaProjects\Java_Tools\src\main\Java\Tools_6\TXT\
     * prefix   文件名         比如: xxx
     * Suffix   文件后缀       比如: .Java
     */
    public static void renameFiles(String dirPath,String prefix , String Suffix){
        File file=new File(dirPath);
        if(!file.isDirectory()){
            return;
        }
        File files[]=file.listFiles();
        int index=1;

        for(File f:files){
            File newFile=new File(dirPath,prefix+String.valueOf(index++) + Suffix);
            f.renameTo(newFile);
        }
    }
}




```
</details>





















<details>
<summary><b> 读取配置文件 ( config.properties )</b></summary>

```  

新建一个配置文件: config.properties
内容如下:
database:user
password:123456


    Properties properties = new Properties();
    // 使用InPutStream流读取properties文件
    BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/Java/Tools_11/config.properties"));
    properties.load(bufferedReader);
    // 获取key对应的value值
    String database = properties.getProperty("database");
    String password = properties.getProperty("password");
    System.out.println(database);
    System.out.println(password);



```
</details>


























<details>
<summary><b> 上传图片(文件) </b></summary>

```

springBoot 中配置文件(application.properties):
spring.http.multipart.maxFileSize=100Mb
spring.http.multipart.maxRequestSize=100Mb


前端页面:
    1. method="post" 是必须的
    2. enctype="multipart/form-data" 是必须的，表示提交二进制文件
    3. name="file" 是必须的，和后续服务端对应
    4. accept="image/*" 表示只选择图片 
<form action="upload" method="post" enctype="multipart/form-data">
  选择图片:<input type="file" name="file" accept="image/*" /> <input type="submit" value="上传">
</form>



Java 后端程序:
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m) {
            try {
            	String fileName = System.currentTimeMillis()+file.getOriginalFilename();
				String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
                System.out.println(req.getServletContext().getRealPath(""));   // C:\Users\SpringBoot\IdeaProjects\springboot\src\main\webapp\
				
				File destFile = new File(destFileName);
				destFile.getParentFile().mkdirs();
            	file.transferTo(destFile);
            	
            	m.addAttribute("fileName",fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "showImg";
    }    

```
</details>
















