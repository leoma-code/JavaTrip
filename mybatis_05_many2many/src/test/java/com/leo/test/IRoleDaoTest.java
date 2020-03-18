package com.leo.test;

import com.leo.dao.IRoleDao;
import com.leo.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public class IRoleDaoTest {

    private InputStream is;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);
        // 3.使用工厂生产SqlSession对象
        session = sessionFactory.openSession();
        // 4.使用SqlSession创建dao接口的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {

        session.commit();

        // 6.释放资源
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
