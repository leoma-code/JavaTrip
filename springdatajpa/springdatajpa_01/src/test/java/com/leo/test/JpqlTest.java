package com.leo.test;

import com.leo.dao.CustomerDao;
import com.leo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindByName() {
        List list = customerDao.findByName("测试姓名");
        System.out.println(list);
    }

    @Test
    public void testFindByNameAndId() {
        Customer customer = customerDao.findByNameAndId("测试姓名", 3l);
        System.out.println(customer);
    }

    /**
     * 测试jpql的更新操作
     * SpringDataJpa中使用jpql完成更新、删除操作
     *      *需要手动添加事务的支持
     *      *默认会执行结束之后，回滚事务
     *
     *   @Rollback(value = false) 设置是否自动回滚
     *
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdate() {
        customerDao.updateCustomer(5l, "测试姓名-update");
    }


    /**
     * 使用sql语句查询
     */
    @Test
    public void testFindBySql() {
        List<Object[]> list = customerDao.findAllBySql();
        for (Object[] objs: list) {
            System.out.println(Arrays.toString(objs));
        }
    }

    @Test
    public void testFindBySqlName() {
        List<Object[]> list = customerDao.findBySqlName("%update");
        for (Object[] objs: list) {
            System.out.println(Arrays.toString(objs));
        }
    }
}
