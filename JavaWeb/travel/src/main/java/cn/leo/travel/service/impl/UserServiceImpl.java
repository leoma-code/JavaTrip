package cn.leo.travel.service.impl;

import cn.leo.travel.dao.UserDao;
import cn.leo.travel.dao.impl.UserDaoImpl;
import cn.leo.travel.domain.User;
import cn.leo.travel.service.UserService;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */
public class UserServiceImpl implements UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {

        UserDao userDao = new UserDaoImpl();

        User u = userDao.findByUsername(user.getUsername());

        if (u != null) {
            // 用户名存在 注册失败
            return false;
        }

        userDao.save(user);

        return true;
    }
}
