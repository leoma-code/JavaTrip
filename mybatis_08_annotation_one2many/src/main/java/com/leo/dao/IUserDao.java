package com.leo.dao;

import com.leo.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public interface IUserDao {


    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "userId", column = "id"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "userName", column = "username"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userAddress", column = "address")
    })
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findUserById(Integer uid);

}
