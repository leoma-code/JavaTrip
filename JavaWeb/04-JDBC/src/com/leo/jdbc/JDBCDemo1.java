package com.leo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCDemo1 {


    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");

        String sql = "update account set balance = 1000 where id = 1";

        Statement stat = conn.createStatement();

        int update = stat.executeUpdate(sql);

        System.out.println("update result - " + update);

        stat.close();
        conn.close();

    }


}
