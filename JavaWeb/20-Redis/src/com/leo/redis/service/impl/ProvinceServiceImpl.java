package com.leo.redis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.redis.dao.ProvinceDao;
import com.leo.redis.dao.impl.ProvinceDaoImpl;
import com.leo.redis.domain.Province;
import com.leo.redis.service.ProvinceService;
import com.leo.redis.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao provinceDao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public String findAllJson() {

        Jedis jedis = JedisUtils.getJedis();

        String province_json = jedis.get("province");

        if (province_json == null || province_json.length() == 0) {
            System.out.println("Redis中没有缓存数据，查询数据库。。。");

            List<Province> list = this.findAll();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                province_json = objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province", province_json);
            jedis.close();

        } else {
            System.out.println("Redis中有缓存数据，使用缓存。。。");
        }
        System.out.println(province_json);

        return province_json;
    }
}
