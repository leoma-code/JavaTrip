package com.leo.dao;

import com.leo.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Leo on 2020/4/3.
 * Description :
 */

public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{userId}")
    User findById(Integer userId);

    @Update("update user set username=#{username},password=#{password},sex=#{sex},age=#{age},email=#{email} where id=#{id}")
    void updateUser(User user);

}
