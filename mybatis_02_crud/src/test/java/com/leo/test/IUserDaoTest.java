package com.leo.test;

import com.leo.dao.IUserDao;
import com.leo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public class IUserDaoTest {

    private InputStream is;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {

        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();

        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {

        // 手动提交事务
        session.commit();

        session.close();
        is.close();
    }

    public static void main(String[] args) throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();

        IUserDao userDao = session.getMapper(IUserDao.class);

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

        session.close();
        is.close();
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("test1");
        user.setAddress("中国");
        user.setSex("男");
        user.setBirthday(new Timestamp(new Date().getTime()));

        userDao.saveUser(user);
    }

}
