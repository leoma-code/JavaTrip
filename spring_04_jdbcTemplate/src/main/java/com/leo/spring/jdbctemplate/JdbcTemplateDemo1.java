package com.leo.spring.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public class JdbcTemplateDemo1 {


    public static void main(String[] args) {

        // 创建数据源  jdbc自带数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/_spring01");
        ds.setUsername("root");
        ds.setPassword("1234");

        // 创建JdbcTemplate
        JdbcTemplate jt = new JdbcTemplate();

        jt.setDataSource(ds);

        jt.update("insert into account (name, money) values ('ggg', 2000)");

    }
}
