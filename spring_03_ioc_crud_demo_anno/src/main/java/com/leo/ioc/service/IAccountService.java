package com.leo.ioc.service;

import com.leo.ioc.domain.Account;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public interface IAccountService {

    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleAccount(Integer id);
}
