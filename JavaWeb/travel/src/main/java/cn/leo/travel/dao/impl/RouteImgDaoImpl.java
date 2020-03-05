package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.RouteImgDao;
import cn.leo.travel.domain.RouteImg;
import cn.leo.travel.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List findRouteImgsByRid(int rid) {

        String sql = "select * from tab_route_img where rid = ?";

        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
