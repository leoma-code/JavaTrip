package com.leo.dao;

import com.leo.domain.QueryVO;
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

    User findById(Integer uid);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询所有记录数
     * @return
     */
    int findTotal();

    /**
     * 根据VO查询
     * @param vo
     * @return
     */
    List<User> findByVO(QueryVO vo);
}
