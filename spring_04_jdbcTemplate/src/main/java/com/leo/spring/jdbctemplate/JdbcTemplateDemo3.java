package com.leo.spring.jdbctemplate;

import com.leo.spring.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public class JdbcTemplateDemo3 {


    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 保存
//        jt.update("insert into account (name, money) VALUES (? , ?)", "eee", 2500);
        // 更新
//        jt.update("update account set name = ? where id = ?", "update name", 7);
        // 删除
//        jt.update("delete from account where id = ?", 7);
        // 查询所有
        List<Account> accounts = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account: accounts) {
            System.out.println(account);
        }
        System.out.println("---------------------------");
        // 查询一个
        List<Account> ats = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 6);
        System.out.println(ats.isEmpty() ? "没有用户" : ats.get(0));
        // 查询返回一行一列 （使用聚合函数，但不加group by）
        Integer count = jt.queryForObject("select count(*) from account", Integer.class);
        System.out.println(count);

    }
}
