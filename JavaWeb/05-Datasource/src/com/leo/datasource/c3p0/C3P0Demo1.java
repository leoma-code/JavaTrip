package com.leo.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Leo on 2020/1/6.
 * Description : C3P0的演示
 */
public class C3P0Demo1 {



    public static void main(String[] args) throws SQLException {

        /**
         * public ComboPooledDataSource(String configName)  读取指定名称的配置，什么都不传使用默认配置
         */
        DataSource ds = new ComboPooledDataSource();

        Connection conn = ds.getConnection();

        System.out.println(conn);




    }

}
