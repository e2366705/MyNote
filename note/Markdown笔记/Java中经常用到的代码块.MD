# 返回当前的时间
```  
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        //sdf.applyPattern("yyyy_MM_dd_HH_mm_ss a");// a为am/pm的标记
        sdf.applyPattern("yyyy_MM_dd__HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）

```


# 判断一个字符串是否含有英文 / 中文 / 数字 / ...
```  
    @Test
    public void test() {

        String str = "asdasdas.";

        //【单词是否全为英文】返回true  否则false
        boolean Whether_all_english = str.matches("[a-zA-Z]+");

        //【全为数字】返回true
        Boolean all_number = str.matches("[0-9]+");

        //【除英文和数字外无其他字符(只有英文数字的字符串)】返回true 否则false
        boolean result2 = str.matches("[a-zA-Z0-9]+");

        //【含有英文】true
        String regex1 = ".*[a-zA-z].*";
        boolean has_english = str.matches(regex1);

        // 含有数字 => true
        String regex2 = ".*[0-9].*";
        boolean has_number = str.matches(regex2);

        //判断是否为纯中文，不是返回false
        String regex3 = "[\\u4e00-\\u9fa5]+";
        boolean all_chinese = str.matches(regex3);

        System.out.println(Whether_all_english);

    }

```



#  生成指定长度的随机字符串（A-Z，a-z，0-9）
```  
    @Test
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

```


# 生成指定长度的数字
```  
while (true){

    Thread.sleep(66);

    int min_number = 5000;
    int max_number = 9000;

    int Random_number = min_number + (int)(Math.random() * (max_number-min_number + 1000 ));
    System.out.println(Random_number);
    
}

```


# 截取字符串(最后2位 / 排除最后2位)
```  
String strhours = String.valueOf(123456789);

// 截取最后2位 => 89
String aaa = strhours.substring(strhours.length() -2, strhours.length());   //截取

// 排除最后2位 => 1234567
String bbb = strhours.substring(0,strhours.length()-2);   //截掉

System.out.println(aaa);
System.out.println(bbb);

```



# Java IO (读 / 写)
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



# JDBC MySQL 增/删/改/查
```  
package com.swjtu;
import org.junit.Test;
import java.sql.*;
public class JDBC_test {
    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
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
    }
}



/*


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
