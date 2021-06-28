package com.crorylove.login;

import com.crorylove.jdbc.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
 *preparedStatement实现
 *  登入方法练习
 *   需求：
 *       通过键盘录入用户名和密码
 *       判断用户登入是否成功
 * */
public class Login01 {
    public static void main(String[] args) {
//        输入用户和密
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入用户密码：");
        String password = scanner.nextLine();
//        调用登入方伐
        Boolean flag = new Login01().login01(username, password);
//        显示是否登入成功
        if (flag) {
            System.out.println("登入成功");
        } else {
            System.out.println("登入失败");
        }
    }

    /*
     * 登入方法
     * 无返回值
     * */
    public boolean login01(String username, String password) {
//        先判断输入数据是否为空，为空返回false,

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        1连接数据库
        try {
            connection = JDBCUtils.getConnection();
//            定义sql语句
            String sql = "select * from user where username =? and password =?";
//            获取sql执行对象
            preparedStatement = connection.prepareStatement(sql);
//            给?赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
//            执行查询
            resultSet = preparedStatement.executeQuery();
//           如果有下一行则返回true
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return false;
    }
}