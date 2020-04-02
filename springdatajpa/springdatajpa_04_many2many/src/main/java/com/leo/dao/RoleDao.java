package com.leo.dao;

import com.leo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
