package com.leo.redis.dao;

import com.leo.redis.domain.Province;

import java.util.List;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public interface ProvinceDao {

    public List<Province> findAll();
}
