package com.leo.dao;

import com.leo.domain.User;

import java.util.List;

/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);
}
