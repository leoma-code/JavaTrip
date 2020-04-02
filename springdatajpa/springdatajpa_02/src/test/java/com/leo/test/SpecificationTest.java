package com.leo.test;

import com.leo.dao.CustomerDao;
import com.leo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecificationTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 自定义查询条件
     *      1、实现Specification接口（提供范性：查询的对象类型）
     *      2、实现toPredicate方法 （构造查询条件）
     *      3、需要借助方法参数中的两个参数（
     *          root：获取需要查询的对象属性
     *          CriteriaBuilder：构造查询条件的，内部封装了很多查询条件(模糊匹配、精准匹配、、、、)
     *      ）
     */
    @Test
    public void testSpec() {

        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Object> custName = root.get("custName");

                Predicate predicate = cb.equal(custName, "测试姓名-update");

                return predicate;
            }
        };
        Customer customer = customerDao.findOne(spec);
        System.out.println(customer);

    }

    /**
     * 多条件查询
     *
     */
    @Test
    public void testSpec1() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Path<Object> custId = root.get("custId");

                Predicate p1 = cb.equal(custId, 4l);
                Predicate p2 = cb.equal(custName, "测试姓名");
//                cb.or()
                Predicate and = cb.and(p1, p2);
                return and;
            }
        };

        List<Customer> list = customerDao.findAll(spec);
        for (Customer customer: list) {
            System.out.println(customer);
        }
    }


    /**
     * 模糊查询
     * equal: 直接得到path对象（属性）,然后进行比较即可
     * gt, lt, ge, le, like 需要得到path对象，并指定比较参数的类型，再去进行比较
     *      * 指定参数类型：path.as(类型字节码对象)
     */
    @Test
    public void testSpec2() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Path<Object> custLevel = root.get("custLevel");

                Predicate p1 = cb.equal(custLevel, "VIP");
                Predicate p2 = cb.like(custName.as(String.class), "测试%");
                Predicate and = cb.and(p1, p2);
                return and;
            }
        };

        List<Customer> list = customerDao.findAll(spec);
        for (Customer customer: list) {
            System.out.println(customer);
        }
    }

    /**
     * 排序查询
     */
    @Test
    public void testSpec3() {

        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Predicate predicate = cb.like(custName.as(String.class), "测试%");
                return predicate;
            }
        };

        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> list = customerDao.findAll(spec, sort);
        for (Customer customer: list) {
            System.out.println(customer);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void testSpec4() {
        Specification<Customer> spec = null;
        Pageable pageable = new PageRequest(0, 2);
        Page<Customer> page = customerDao.findAll(null, pageable);
        System.out.println(page.getContent());
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}
