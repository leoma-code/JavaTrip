package com.leo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCDemo2 {


    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");

            String sql = "INSERT INTO account VALUES (NULL , '王五', '1000')";

            stat = conn.createStatement();

            int insert = stat.executeUpdate(sql);

            System.out.println("insert result - " + insert);

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
