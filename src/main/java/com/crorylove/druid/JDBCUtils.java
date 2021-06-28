package com.crorylove.druid;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource ds;
    static {
        try {
            //加载properties
            Properties properties = new Properties();
            //读取druid.properties
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取数据源
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取connection连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取连接池数据源
     * @return
     */
    public  static DataSource getDateSource(){
        return ds;
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     * @param resultSet
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection){
        JDBCUtils.close(statement,connection,null);
    }
}

