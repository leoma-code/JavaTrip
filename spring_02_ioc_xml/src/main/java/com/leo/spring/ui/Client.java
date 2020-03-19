package com.leo.spring.ui;

import com.leo.spring.dao.IAccountDao;
import com.leo.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public class Client {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

//        IAccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }


}
