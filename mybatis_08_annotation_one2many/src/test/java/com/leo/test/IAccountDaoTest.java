package com.leo.test;

import com.leo.dao.IAccountDao;
import com.leo.domain.Account;
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
public class IAccountDaoTest {

    private InputStream is;
    private SqlSession sqlSession;
    private IAccountDao accountDao;


    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        sqlSession = sessionFactory.openSession();

        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception {

        sqlSession.commit();

        sqlSession.close();

        is.close();
    }


    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }



}
