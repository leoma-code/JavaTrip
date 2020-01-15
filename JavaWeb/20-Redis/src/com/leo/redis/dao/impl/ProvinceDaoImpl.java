package com.leo.redis.dao.impl;

import com.leo.redis.dao.ProvinceDao;
import com.leo.redis.domain.Province;
import com.leo.redis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Province> findAll() {

        String sql = "select * from province";

        List<Province> provinceList = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return provinceList;
    }
}
