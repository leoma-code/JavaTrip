package com.leo.spring.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public class JdbcTemplateDemo2 {


    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        jt.update("insert into account (name, money) values ('hhh', 2000)");

    }
}
