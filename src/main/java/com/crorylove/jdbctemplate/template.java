package com.crorylove.jdbctemplate;
/*
 * springTemplate入门
 * */


import com.crorylove.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class template {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
//        定义sql
        String sql="update user set password = ? where username = 'zs';";
        int i = jdbcTemplate.update(sql, 999);
        System.out.println(i);
    }
}
