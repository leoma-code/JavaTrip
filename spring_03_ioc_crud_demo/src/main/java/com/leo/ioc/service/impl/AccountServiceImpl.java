package com.leo.ioc.service.impl;

import com.leo.ioc.dao.IAccountDao;
import com.leo.ioc.domain.Account;
import com.leo.ioc.service.IAccountService;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleAccount(Integer id) {
        accountDao.deleAccount(id);
    }
}
