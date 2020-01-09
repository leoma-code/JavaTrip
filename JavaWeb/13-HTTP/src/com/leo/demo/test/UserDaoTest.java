package com.leo.demo.test;

import com.leo.demo.dao.UserDao;
import com.leo.demo.domain.User;
import org.junit.Test;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */
public class UserDaoTest {

    @Test
    public void testLogin() {

        User loginUser = new User();
        loginUser.setUsername("Tom");
        loginUser.setPassword("1234");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        System.out.println(user);
    }

}
