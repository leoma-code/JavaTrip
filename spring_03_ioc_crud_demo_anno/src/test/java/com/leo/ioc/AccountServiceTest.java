package com.leo.ioc;

import com.leo.ioc.domain.Account;
import com.leo.ioc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */
public class AccountServiceTest {


    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl", IAccountService.class);

        List<Account> accounts = accountService.findAll();

        for (Account account: accounts) {
            System.out.println(account);
        }
    }


    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountServiceImpl", IAccountService.class);

        Account account = accountService.findById(1);

        System.out.println(account);
    }

    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setName("test1");
        account.setMoney(5000f);

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setId(4);
        account.setName("test2");
        account.setMoney(3000f);

        accountService.updateAccount(account);
    }

    @Test
    public void testDele() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService accountService = ac.getBean("accountService", IAccountService.class);

        accountService.deleAccount(4);
    }


}
