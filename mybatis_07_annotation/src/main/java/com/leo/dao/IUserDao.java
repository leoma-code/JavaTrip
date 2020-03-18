package com.leo.dao;

import com.leo.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public interface IUserDao {


    @Select("select * from user")
    List<User> findAll();


    @Insert("insert into user (username, birthday, sex, address) values (#{username}, #{birthday}, #{sex}, #{address})")
    void insertUser(User user);

    @Update("update user set username = #{username} where id = #{id}")
    void  updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(Integer userId);
}
