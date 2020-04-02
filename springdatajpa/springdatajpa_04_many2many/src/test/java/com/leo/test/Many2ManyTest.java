package com.leo.test;

import com.leo.dao.RoleDao;
import com.leo.dao.UserDao;
import com.leo.domain.Role;
import com.leo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Many2ManyTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;


    @Test
    @Transactional
    @Rollback(false)
    public void testAdd() {

        User user = new User();
        user.setUserName("小李");

        Role role = new Role();
        role.setRoleName("JAVA开发工程师");

        user.getRoles().add(role);
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * 级联操作和一对多一致 配置cascade属性
     */


}
