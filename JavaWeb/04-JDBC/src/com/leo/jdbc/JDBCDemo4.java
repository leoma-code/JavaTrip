package com.leo.jdbc;

import com.leo.domain.Emp;
import com.leo.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCDemo4 {


    public static void main(String[] args) {

        List<Emp> empList = new JDBCDemo4().findAllUseUtils();

        System.out.println(empList);

    }


    public List<Emp> findAllUseUtils() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> empList = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from emp";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            Emp emp = null;
            empList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                empList.add(emp);
            }

            System.out.println(empList);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }


        return  empList;
    }

    public List<Emp> findAll() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> empList = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "1234");

            String sql = "select * from emp";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            Emp emp = null;
            empList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                empList.add(emp);
            }

            System.out.println(empList);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
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


        return  empList;
    }
}
