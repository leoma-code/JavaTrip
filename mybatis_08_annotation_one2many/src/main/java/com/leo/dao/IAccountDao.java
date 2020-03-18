package com.leo.dao;

import com.leo.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public interface IAccountDao {


    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid",
                    one = @One(select = "com.leo.dao.IUserDao.findUserById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    @ResultMap("accountMap")
    List<Account> findAccountByUid(Integer uid);

}
