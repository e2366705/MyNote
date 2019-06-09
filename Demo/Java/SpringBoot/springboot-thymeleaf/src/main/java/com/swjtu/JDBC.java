package com.swjtu;

import java.sql.*;

public class JDBC {


    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/english_word?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
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


    public void Find_all(){
        Connection conn = getConn();
        Statement stmt = null;
        try {
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM `words_warehouse`";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                String word = rs.getString("word");
                String chinese_meaning = rs.getString("chinese_meaning");

                System.out.printf("单词:  %-30s 中文意思:  %d\n", word, chinese_meaning);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public String Find_all_limit() throws SQLException {
        Connection conn = getConn();
        Statement stmt = null;
        System.out.println(" 实例化Statement对象...");
        stmt = conn.createStatement();
        String sql;

        sql = "SELECT * FROM `words_warehouse` where `chinese_meaning` is null LIMIT 1 ;";
        ResultSet rs = stmt.executeQuery(sql);

        String word = null;

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            word = rs.getString("word");
            String chinese_meaning = rs.getString("chinese_meaning");

            System.out.printf("单词:  %-30s 中文意思:  %d\n", word, chinese_meaning);
        }

        if (rs != null){
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
        return word;
    }




    public int  update_chinese_mean(String word , String chinese_mean) throws SQLException {

        Connection conn = getConn();
        Statement stmt = null;
        System.out.println(" 实例化Statement对象...");
        stmt = conn.createStatement();
        String sql;

        sql = "UPDATE `words_warehouse` SET `chinese_meaning`='" + chinese_mean + "' WHERE `word`='" + word + "';";
        int status = stmt.executeUpdate(sql);

        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
        return status;
    }




        int count = 0;


        public int Insert(String word) throws SQLException {
            Connection conn = getConn();
            int i = 0;
            String sql = "INSERT into `words_warehouse`(`word`) VALUES('" + word + "');";
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
                if (i > 0){
                    System.out.println("成功插入一条数据:   " + word);
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                pstmt.close();
                conn.close();
            }
            return count;
        }




}