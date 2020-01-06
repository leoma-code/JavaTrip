package com.leo.datasource.druid;

import com.leo.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class DruidDemo1 {

    public static void main(String[] args) throws Exception {

        /*
        Properties pro = new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();

        System.out.println(conn);
        */

        testJDBCUtils();
    }


    public static void testJDBCUtils() throws SQLException {

        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);

        String sql = "select * from emp";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ename - " + rs.getString("ename"));
        }

        JDBCUtils.close(rs, stmt, conn);

    }


}
