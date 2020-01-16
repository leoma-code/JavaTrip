package cn.leo.travel.service.impl;

import cn.leo.travel.dao.UserDao;
import cn.leo.travel.dao.impl.UserDaoImpl;
import cn.leo.travel.domain.User;
import cn.leo.travel.service.UserService;
import cn.leo.travel.util.MailUtils;
import cn.leo.travel.util.UUIDUtils;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {

        User u = userDao.findByUsername(user.getUsername());

        if (u != null) {
            // 用户名存在 注册失败
            return false;
        }

        // 设置激活码 用于邮件激活注册账号
        user.setCode(UUIDUtils.getUuid());
        // 设置用户激活状态
        user.setStatus("N");

        // 注册用户
        userDao.save(user);

        // 注册用户成功 发送激活邮件
        String content = "<a href='http://localhost/travel/activeUserServlet?code=" + user.getCode() + "'>点击激活，【旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }

    // 激活用户
    @Override
    public boolean active(String code) {

        // 根据激活码查询用户
        User user = userDao.findByCode(code);

        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }
}
