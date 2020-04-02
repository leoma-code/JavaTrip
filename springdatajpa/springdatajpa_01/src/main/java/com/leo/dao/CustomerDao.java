package com.leo.dao;

import com.leo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 *
 *  JpaRepository<实体类型，主键类型>：用来完成基本的CRUD操作
 *  JpaSpecificationExecutor<实体类型>：用来完成复杂查询(分页等查询操作)
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {


    @Query(value = "from Customer where custName = ?")
    public List<Customer> findByName(String custName);


    @Query(value = "from Customer where custName = ? and custId = ?")
    public Customer findByNameAndId(String custName, Long id);

    /**
     * ?1 指定占位符对应参数的索引
     * @Modifying 指定是修改语句
     */
    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(Long id, String custName);


    /**
     * 使用sql的形式查询
     *      查询全部
     * sql： select * from cst_customer
     * Query：配置sql查询
     *      value：sql语句
     *      nativeQuery：查询方式
     *          *false：jpql查询，默认
     *          *true：sql查询
     * @return
     */
    @Query(value = "select * from cst_customer", nativeQuery = true)
    public List<Object[]> findAllBySql();


    @Query(value = "select * from cst_customer where cust_name like ?1 ", nativeQuery = true)
    public List<Object[]> findBySqlName(String name);
}
