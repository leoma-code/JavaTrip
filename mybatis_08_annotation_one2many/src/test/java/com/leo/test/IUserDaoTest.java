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

import java.io.InputStream;
import java.util.List;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public class IUserDaoTest {

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;


    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = sessionFactory.openSession();

        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {

        sqlSession.commit();

        sqlSession.close();

        is.close();
    }


    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserById() {
        User user = userDao.findUserById(41);
        System.out.println(user);
    }

}
