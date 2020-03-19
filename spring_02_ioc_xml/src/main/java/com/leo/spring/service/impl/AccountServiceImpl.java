package com.leo.spring.service.impl;

import com.leo.spring.dao.IAccountDao;
import com.leo.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = context.getBean("accountDao", IAccountDao.class);

        accountDao.saveAccount();

    }
}
