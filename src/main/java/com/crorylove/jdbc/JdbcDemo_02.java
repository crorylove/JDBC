package com.crorylove.jdbc;
/*
* 测试jdbc工具类
* */

import java.sql.*;

public class JdbcDemo_02 {
    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","320306862hj.");

            con = JDBCUtils.getConnection();

            String sql = "select * from user where username ='黄健'";
//        获取sql对象
            statement = con.createStatement();
//        执行sql
            rs = statement.executeQuery(sql);
//           游标下移
//          获取数据
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString("username");
                System.out.println(id + "=====" + username);
            }
//        处理结果
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           JDBCUtils.close(rs,statement,con);
        }
    }
}
