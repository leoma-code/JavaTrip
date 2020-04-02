package com.leo.dao;

import com.leo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
