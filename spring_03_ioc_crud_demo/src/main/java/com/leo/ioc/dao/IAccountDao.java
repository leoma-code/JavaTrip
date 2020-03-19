package com.leo.ioc.dao;

import com.leo.ioc.domain.Account;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public interface IAccountDao {

    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleAccount(Integer id);
}
