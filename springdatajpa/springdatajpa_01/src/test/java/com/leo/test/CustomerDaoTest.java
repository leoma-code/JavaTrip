package com.leo.test;

import com.leo.dao.CustomerDao;
import com.leo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * save(obj) 方法
     * 对象中存在主键ID 为更新 不存在为保存
     */
    @Test
    public void testSave() {
        Customer c = new Customer();
        c.setCustName("测试姓名");
        customerDao.save(c);
    }

    @Test
    public void testUpdate() {

        // 执行更新操作，先根据ID查询 再更新，负责未赋值字段会被清空
        Customer customer = new Customer();
        customer.setCustId(2l);
        customer.setCustName("测试姓名-更新-更新");
//        customer.setCustLevel("VIP");
        customerDao.save(customer);
    }

    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for (Customer customer: list) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(2l);
        System.out.println(customer);
    }


}
