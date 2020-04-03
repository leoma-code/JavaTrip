package com.leo.service;

import com.leo.domain.User;

import java.util.List;

/**
 * Created by Leo on 2020/4/3.
 * Description :
 */
public interface UserService {

    List<User> findAll();

    User findById(Integer userId);

    void updateUser(User user);
}
