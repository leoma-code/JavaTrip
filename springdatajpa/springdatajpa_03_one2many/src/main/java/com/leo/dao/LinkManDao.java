package com.leo.dao;

import com.leo.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 *
 *  JpaRepository<实体类型，主键类型>：用来完成基本的CRUD操作
 *  JpaSpecificationExecutor<实体类型>：用来完成复杂查询(分页等查询操作)
 */
public interface LinkManDao extends JpaRepository<LinkMan, Long>, JpaSpecificationExecutor<LinkMan> {



}
