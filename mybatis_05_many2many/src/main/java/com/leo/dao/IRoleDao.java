package com.leo.dao;

import com.leo.domain.Role;

import java.util.List;

/**
 * Created by Leo on 2020/3/18.
 * Description :
 */
public interface IRoleDao {

    List<Role> findAll();
}
