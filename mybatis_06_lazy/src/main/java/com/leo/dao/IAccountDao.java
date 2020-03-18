package com.leo.dao;

import com.leo.domain.Account;

import java.util.List;

/**
 * Created by Leo on 2020/3/17.
 * Description :
 */
public interface IAccountDao {

    /**
     * 查询所有操作并包含用户信息
     * @return
     */
    List<Account> findAll();

    List<Account> findAccountByUid(Integer uid);

}
