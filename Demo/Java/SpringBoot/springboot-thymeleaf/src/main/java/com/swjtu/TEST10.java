package com.swjtu;//package com.hehe.controller;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import static java.util.jar.Pack200.Packer.PASS;
//import static javax.swing.Action.NAME;
//
//public class Test10 {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        //加载驱动程序
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //获取数据库连接
//        Connection conn = DriverManager.getConnection(URL, NAME, PASS);
//
//        //创建Statement对象
//        Statement stmt = (Statement) conn.createStatement();
//
//        String sql = "insert into goodess (user_name,sex,birthday,add_time,update_time) values (?,?,current_date,current_date)";
//        //预编译
//
//        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
//        //为预编译的占位符赋值
//
//        ptmt.setString(1, "qweqwe");
//        ptmt.setInt(2, 123);
//
//        //执行sql语句
//        ptmt.execute();
//    }
//}
