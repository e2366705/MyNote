

# 注意: SpringBoot是不用自己去配置Tomcat的!!!
## 妈的, 我在2020-01-23这一天折腾了好几个小时, 死活配置不好Tomacat, 突然想起来SpringBoot是不用配置Tomcat的....



#### 4个 # 比较合适...

```  


```


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
import javazoom.jl.player.*;


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
<summary><b>System.out.printf 格式化</b></summary>

```  
    System.out.printf("单词:%-66s 出现次数:%d\n", "aaa", 123);
    System.out.printf("单词:%-66s 出现次数:%d\n", "eqweqweqweqweqw", 3123123);
    System.out.printf("单词:%-66s 出现次数:%d\n", "q", 7);

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
<summary><b>字符串是否含有英文 / 中文 / 数字 / 替换/ 时间 / 随机数 / 随机字符串 / 截取字符串</b></summary>

```  
        大写:
        str.toUpperCase();

        小写:
        str.toLowerCase()

        返回当前时间:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println( "现在是:  " +  df.format(new Date()));// new Date()为获取当前系统时间

        System.out.printf("现在是:  %66s  \n" , df.format(new Date()));
        System.out.printf("现在是:  %-66s   " , df.format(new Date()));


    @Test
    public void test() {

        String str = "asdasdas.";

        //单词是否全为英文
        // true  false
        boolean Whether_all_english = str.matches("[a-zA-Z]+");

        // 是否有中文? 允许有符号
        String str = "my friends gardens and we've become closer '' * & ^ % # @ ! ` ~     ";
        if (str.getBytes().length == str.length()) {
            System.err.println("english....");
        }else {
            System.err.println("those string has chinese....");
        }

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


        // 含有中文
        //  true false
        String world_2 = "哈哈哈aaaaaaa";
        for (char c : world_2.toCharArray()) {
            if (isChinese(c)) {
                System.out.println("含有中文");
            }
        }

        //判断是否为纯中文
        //  true false
        String regex3 = "[\\u4e00-\\u9fa5]+";
        boolean all_chinese = str.matches(regex3);

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
    }



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



        截取字符串(最后2位 / 排除最后2位)
        String strhours = String.valueOf(123456789);

        // 截取最后2位 => 89
        String aaa = strhours.substring(strhours.length() -2, strhours.length());   //截取

        // 排除最后2位 => 1234567
        String bbb = strhours.substring(0,strhours.length()-2);   //截掉

        System.out.println(aaa);
        System.out.println(bbb);




        // 分割字符串
        String str = "www-runoob-com";
        String[] temp;
        String delimeter = "-";  // 指定分割字符
        temp = str.split(delimeter); // 分割字符串
        // 普通 for 循环
        for(int i =0; i < temp.length ; i++){
            System.out.println(temp[i]);
            System.out.println("");
        }






=====================================   替换字符串   ==============================================

第一种:
        String str = "“i’m, nana’s, ’ ‘at, ’ ‘as, foo  - ,  twice a, \"sadas\" ce of, ties, 123890 \\ ’";
        
        //可以在中括号内加上任何想要替换的字符 (数字也会被去掉)，实际上是一个正则表达式
        String regEx="[\n`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】‘；\\-：”“’。，\\\\ 、？0123456789\"]";
        
        String newString = str.replaceAll(regEx," ");    // 替换成 ' '
        System.out.println(newString);



第二种: 
    相对比较简单 (推荐)
    直接用 replaceAll 删除非英文字母的字母:
        String temp = "";
        temp = str.replaceAll("[^a-zA-Z]", " ");
        System.out.println(temp);        


其他:
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
<summary><b>Java IO (读 / 写)</b></summary>

```  
package com.swjtu;
import org.junit.Test;
import java.io.*;
public class IO {


    private String file_name = "test.txt";
    private String path = "src/main/java/com/hehe/Article/";
    private String file_path = path + file_name;
    

    /**
     *   读 文本文件
     *   推荐 ^_^
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
     */
    @Test
    public void test8() {
        /**
         推荐这种方式:
         原因: 换行符正常导入 , 文本文件有换行符, 文本文件保持原样
         而且不会中文乱码...
         */
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
     *   读 read
     */
    @Test
    public void test3() {

        /**
             不推荐这种方式:
             原因: 换行符无法正常导入 , 导致文本数据为一整行, 没有换行符, 文本文件失去美观
         */

        String string = null;
        try {
            // 在给定从中读取数据的文件名的情况下创建一个新 FileReader
            FileReader fr = new FileReader(file_path);

            // 创建一个使用默认大小输入缓冲区的缓冲字符输入流
            BufferedReader br = new BufferedReader(fr);

            StringBuffer stringBuffer = new StringBuffer();

            while (null != (string = br.readLine())) {
                stringBuffer.append(string);
            }
            System.out.println(stringBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     *   读 read
     */
    @Test
    public void test4() throws IOException {
        /**
             不推荐这种方式:
             原因: 换行符无法正常导入 , 导致文本数据为一整行, 没有换行符, 文本文件失去美观
         */

        FileInputStream fin = new FileInputStream(file_path);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);

        StringBuffer stringBuffer = new StringBuffer();
        String strTmp = "";
        while ((strTmp = buffReader.readLine()) != null) {
            stringBuffer.append(strTmp);
        }
        System.out.println(stringBuffer);
        buffReader.close();
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
        String sql = "insert into `user` values(?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.println(ps.toString());      // 输出 SQL 语句

        ps.setString(1, "aaa");
        ps.setInt(2, 6);

        int i = ps.executeUpdate();

        System.out.printf("添加了  %-12s  条数据" , i);

        ps.close();
        conn.close();
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
        String sql = "UPDATE `user` SET `username`=? WHERE `username`=?;";
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

        String sql = "SELECT * FROM `user`";
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
        String sql = "select `phrase`,`chinese_meaning` from `phrase` where `phrase` LIKE ? ";
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














































<details>
<summary><b>正则表达式</b></summary>

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
        String source = "1234567890, 12345,  and  9876543210";
        Matcher m = p.matcher(source);

        while(m.find()){
            System.out.println("Phone: " + m.group() + ", Formatted Phone:  ("
                    + m.group(1) + ") " + m.group(2) + "-" + m.group(3));
        }





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








































---
# 集合
<details>
<summary><b>集合简介:</b></summary>

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

```
</details>




<details>
<summary><b>Collection ( List Set )</b></summary>

```  

void add(String item)  //依次往后添加添加元素
void add(String item, int index) //在指定位置处添加元素
void remove(int position) //删除第几个元素（索引从0开始）
void remove(String item) //删除相同的元素
void removeAll() //删除所有元素



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
1. add(E e): 将指定元素添加到此列表的结尾。
2. add(int index, E element)：在此列表中指定的位置插入指定的元素。
3. addAll(Collection<? extends E> c)：添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。
4. addAll(int index, Collection<? extends E> c)：将指定 collection 中的所有元素从指定位置开始插入此列表。
5. AddFirst(E e): 将指定元素插入此列表的开头。
6. addLast(E e): 将指定元素添加到此列表的结尾。
7. clear()： 从此列表中移除所有元素。
8. remove()：获取并移除此列表的头（第一个元素）。
9. remove(int index)：移除此列表中指定位置处的元素。
10. remove(Objec o)：从此列表中移除首次出现的指定元素（如果存在）。
11. removeFirst()：移除并返回此列表的第一个元素。
12. removeFirstOccurrence(Object o)：从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。
13. removeLast()：移除并返回此列表的最后一个元素。
14. removeLastOccurrence(Object o)：从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）。
15. get(int index)：返回此列表中指定位置处的元素。
16. getFirst()：返回此列表的第一个元素。
17. getLast()：返回此列表的最后一个元素。
18. indexOf(Object o)：返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
19. lastIndexOf(Object o)：返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。






===============================================================================================


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








循环 / 遍历 / 迭代:
---------------------------------------------------------------------------------------
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




set的三种遍历方式:        
---------------------------------------------------------------------------------------
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


HashMap类
void	             clear()
Object	             clone()
boolean	             containsKey(Object key)
boolean         	 containsValue(Object value)
Set<Map.Entry<K,V>>  entrySet()  返回一个包含HashMap的键值对的set
V	                 get(Object key) 根据键获取值
boolean	             isEmpty() 
Set<K>	             keySet()    返回一个HashMap键的Set
V	                 put(K key, V value)
void	             putAll(Map<? extends K,? extends V> m)
V	                 remove(Object key) 根据键移除
int	                 size()
Collection<V>	     values() 返回一个HashMap的值的Collection




HashTable类
synchronized void                clear()
synchronized Object              clone()
             boolean             contains(Object value)
synchronized boolean             containsKey(Object key)
synchronized boolean             containsValue(Object value)
synchronized Enumeration<V>      elements()
synchronized Set<Entry<K, V>>    entrySet()
synchronized boolean             equals(Object object)
synchronized V                   get(Object key)
synchronized int                 hashCode()
synchronized boolean             isEmpty()
synchronized Set<K>              keySet()
synchronized Enumeration<K>      keys()
synchronized V                   put(K key, V value)
synchronized void                putAll(Map<? extends K, ? extends V> map)
synchronized V                   remove(Object key)
synchronized int                 size()
synchronized String              toString()
synchronized Collection<V>       values()





TreeMap类
Entry<K, V>                ceilingEntry(K key)
K                          ceilingKey(K key)
void                       clear()
Object                     clone()
Comparator<? super K>      comparator()
boolean                    containsKey(Object key)
NavigableSet<K>            descendingKeySet()
NavigableMap<K, V>         descendingMap()
Set<Entry<K, V>>           entrySet()
Entry<K, V>                firstEntry()
K                          firstKey()
Entry<K, V>                floorEntry(K key)
K                          floorKey(K key)
V                          get(Object key)
NavigableMap<K, V>         headMap(K to, boolean inclusive)
SortedMap<K, V>            headMap(K toExclusive)
Entry<K, V>                higherEntry(K key)
K                          higherKey(K key)
boolean                    isEmpty()
Set<K>                     keySet()
Entry<K, V>                lastEntry()
K                          lastKey()
Entry<K, V>                lowerEntry(K key)
K                          lowerKey(K key)
NavigableSet<K>            navigableKeySet()
Entry<K, V>                pollFirstEntry()
Entry<K, V>                pollLastEntry()
V                          put(K key, V value)
V                          remove(Object key)
int                        size()
SortedMap<K, V>            subMap(K fromInclusive, K toExclusive)
NavigableMap<K, V>         subMap(K from, boolean fromInclusive, K to, boolean toInclusive)
NavigableMap<K, V>         tailMap(K from, boolean inclusive)
SortedMap<K, V>            tailMap(K fromInclusive)






map的四种遍历方式:
---------------------------------------------------------------------------------------
        //方法一: 用entrySet()  
        //返回的 set 中的每个元素都是一个 Map.Entry 类型。
        // 推荐，尤其是容量大时
        System.out.println("\n=====用entrySet()=======");
        Iterator it1 = map.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry m=(Map.Entry)it1.next();
            System.out.println("[name = " + m.getKey() 
                + "] age = " + m.getValue());
        }


        // 方法二：jdk1.5支持，用entrySet()和For-Each循环()
        System.out.println("\n=用entrySet()和For-Each===");
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("[name = " + m.getKey() + "] age = " + m.getValue());
        }


        // 方法三：用keySet() 普遍使用，二次取值
        System.out.println("\n=====用keySet()=======");
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()){
            String key = (String) it2.next();
            System.out.println("[name = " + key 
                + "] age = " + map.get(key) );
        }


        // 方法四：jdk1.5支持，用keySEt()和For-Each循环
        System.out.println("\n=====用keySet()和For-Each=====");
        for(Object key: map.keySet()){
            System.out.println("[name = " + key 
                + "] age = " + map.get(key) );
        }





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
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            //map转JSON
            Map < String,Object > map = new HashMap < String,Object > ();
            map.put("one", new User("张", 12, "深圳"));
            map.put("two", new User("李", 22, "武汉"));
            map.put("three", new User("王", 32, "北京"));

            System.out.println("ObjectMapper方式");
            objectMapper.writeValue(System.out, map); 

            // 将转换好的数据, 写入到本地的 txt 文件当中
            objectMapper.writeValue(new File("D:TEST.txt"), map);

             System.out.println("JsonGenerator方式");
            jsonGenerator.writeObject(map);

        } catch(IOException e) {
            e.printStackTrace();
        }

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


    @Test
    public void List_to_JSON(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            //list转JSON
            List < User > list = new ArrayList < User > ();
            list.add(new User("张", 12, "深圳"));
            list.add(new User("李", 22, "武汉"));
            list.add(new User("王", 32, "北京"));
            System.out.println("ObjectMapper方式");
            objectMapper.writeValue(System.out, list);
            System.out.println("JsonGenerator方式");
            jsonGenerator.writeObject(list);
        } catch(IOException e) {
            e.printStackTrace();
        }
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





---



<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>











