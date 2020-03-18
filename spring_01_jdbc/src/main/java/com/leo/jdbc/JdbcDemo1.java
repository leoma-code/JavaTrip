package com.leo.jdbc;

import java.sql.*;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 *
 *      耦合：程序间的依赖官修
 *          包括：
 *              类之间的依赖
 *              方法之间的依赖
 *      解藕：
 *          降低程序间的依赖关系
 *      实际开发中：
 *          应该做到：编译期不依赖，运行时才依赖
 *      解藕的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二步：通过读取配置文件来获取要创建对象的全限定类名
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/_spring01", "root", "1234");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM account");
        //4.执行sql获取结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        //6.关闭资源
        rs.close();
        pstm.close();
        conn.close();
    }


}
