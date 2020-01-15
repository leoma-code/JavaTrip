package com.leo.redis.service;

import com.leo.redis.domain.Province;

import java.util.List;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();
}
