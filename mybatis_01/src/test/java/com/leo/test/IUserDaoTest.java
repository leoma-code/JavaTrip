package com.leo.test;

import com.leo.dao.IUserDao;
import com.leo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public class IUserDaoTest {

    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = sessionFactory.openSession();
        // 4.使用SqlSession创建dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 6.释放资源
        session.close();
        is.close();
    }
}
