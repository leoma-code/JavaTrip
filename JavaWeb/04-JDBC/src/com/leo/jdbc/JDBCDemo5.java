package com.leo.jdbc;

import com.leo.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCDemo5 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = JDBCUtils.getConnection();

            conn.setAutoCommit(false);

            String sql1 = "update account set balance = balance - ? where id = ? ";
            String sql2 = "update account set balance = balance + ? where id = ? ";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);

            pstmt2.setDouble(1, 500);
            pstmt2.setDouble(2, 2);

            pstmt1.executeUpdate();

            int i = 1 / 0;

            pstmt2.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }


    }




}
