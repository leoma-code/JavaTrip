package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.SellerDao;
import cn.leo.travel.domain.Seller;
import cn.leo.travel.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class SellerDaoImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Seller findSellerBySid(int sid) {

        String sql = "select * from tab_seller where sid = ?";

        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);
    }
}
