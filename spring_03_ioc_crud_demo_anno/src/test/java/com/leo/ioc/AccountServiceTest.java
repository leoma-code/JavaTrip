package com.leo.ioc;

import com.leo.ioc.domain.Account;
import com.leo.ioc.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Leo on 2020/3/19.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;


    @Test
    public void testFindAll() {

        List<Account> accounts = accountService.findAll();

        for (Account account: accounts) {
            System.out.println(account);
        }
    }


    @Test
    public void testFindOne() {

        Account account = accountService.findById(1);

        System.out.println(account);
    }

    @Test
    public void testSave() {

        Account account = new Account();
        account.setName("test1");
        account.setMoney(5000f);

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        Account account = new Account();
        account.setId(4);
        account.setName("test2");
        account.setMoney(3000f);

        accountService.updateAccount(account);
    }

    @Test
    public void testDele() {

        accountService.deleAccount(4);
    }


}
