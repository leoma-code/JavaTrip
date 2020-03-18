package com.leo.dao;

import com.leo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
            @Result(property = "userAddress", column = "address"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.leo.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findUserById(Integer uid);

}
