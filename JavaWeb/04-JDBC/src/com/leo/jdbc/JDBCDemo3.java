package com.leo.jdbc;

import java.sql.*;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCDemo3 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");

            stat = conn.createStatement();

            String sql = "select * from account";

            resultSet = stat.executeQuery(sql);

            while (resultSet.next()) {
                int idInt = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble(3);
                System.out.println("id: " + idInt + " name: " + name + " balance: " + balance);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
