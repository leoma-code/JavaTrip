package cn.leo.travel.dao;

import cn.leo.travel.domain.User;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户
     * @param user
     */
    public void save(User user);

    /**
     * 根据激活码查询用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 更新用户激活状态
     * @param user
     */
    void updateStatus(User user);
}
