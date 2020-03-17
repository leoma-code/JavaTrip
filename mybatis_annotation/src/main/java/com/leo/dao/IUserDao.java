package com.leo.dao;

import com.leo.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */

    @Select("select * from user")
    List<User> findAll();
}
