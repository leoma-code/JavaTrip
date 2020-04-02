package com.leo.test;

import com.leo.dao.CustomerDao;
import com.leo.dao.LinkManDao;
import com.leo.domain.Customer;
import com.leo.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class One2ManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd() {

        Customer customer = new Customer();
        customer.setCustAddress("地址");
        customer.setCustIndustry("企业");
        customer.setCustLevel("VIP");
        customer.setCustName("姓名");
        customer.setCustPhone("1898888");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmEmail("@163.com");
        linkMan.setLkmGender("女");
        linkMan.setLkmMobile("18888");
        linkMan.setLkmName("业务员1");

        // 一的一方具有外键的维护权（update语句），由于配置了一的一方到多的一方的关联关系（会产生多的一条update语句）
        // 可以一的一方实体类中放弃外键维护权
        customer.getLinkMans().add(linkMan);
        // 由于配置了多的一方到一的一方的关联关系 当保存的时候，就会对外键进行赋值
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }


    /**
     * 级联操作：级联添加
     * 保存一个客户的同时，保存客户的所有联系人
     *      * 需要在操作主体的实体类上，配置cascade属性
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd() {

        Customer customer = new Customer();
        customer.setCustAddress("地址");
        customer.setCustIndustry("企业");
        customer.setCustLevel("VIP");
        customer.setCustName("姓名");
        customer.setCustPhone("1898888");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmEmail("@163.com");
        linkMan.setLkmGender("女");
        linkMan.setLkmMobile("18888");
        linkMan.setLkmName("业务员1");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkmEmail("1@163.com");
        linkMan1.setLkmGender("女1");
        linkMan1.setLkmMobile("188881111");
        linkMan1.setLkmName("业务员2");

        customer.getLinkMans().add(linkMan);
        customer.getLinkMans().add(linkMan1);

        linkMan.setCustomer(customer);
        linkMan1.setCustomer(customer);

        customerDao.save(customer);
    }


    /**
     * 级联操作：级联删除
     * 删除一个客户的同时，删除客户的所有联系人
     *      * 需要在操作主体的实体类上，配置cascade属性
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeDelete() {

        // 获取用户
        Customer customer = customerDao.findOne(1l);
        // 级联删除
        customerDao.delete(customer);
    }














    @Test
    @Transactional
    @Rollback(false)
    public void testAdd100000() {

        for (int i = 0; i < 100000; i++) {
            Customer customer = new Customer();
            customer.setCustAddress("地址" + i);
            customer.setCustIndustry("企业" + i);
            customer.setCustLevel("VIP" + i);
            customer.setCustName("姓名" + i);
            customer.setCustPhone("1898888" + i);

            LinkMan linkMan = new LinkMan();
            linkMan.setLkmEmail(i + "@163.com");
            linkMan.setLkmGender(i % 2 == 0 ? "男" : "女");
            linkMan.setLkmMobile("18888" + i);
            linkMan.setLkmName("业务员1");

//        customer.getLinkMans().add(linkMan);

            linkMan.setCustomer(customer);

            customerDao.save(customer);
            linkManDao.save(linkMan);
        }

    }


}
