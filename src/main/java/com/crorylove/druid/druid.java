package com.crorylove.druid;

/*
 * 使用druid连接池工具类
 * */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class druid {
    public static void main(String[] args) {
        /*
         * 在user表中完成添加操作
         * */

        try {
            //        获取连接
            Connection connection = JDBCUtils.getConnection();
//            定义sql
            String sql = "insert into user values(null,?,?);";
//            获取预编译对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            给?赋值
            preparedStatement.setString(1, "ww");
            preparedStatement.setString(2, "1234");
//          执行sql
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
