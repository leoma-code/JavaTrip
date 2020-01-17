package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.RouteDao;
import cn.leo.travel.domain.Route;
import cn.leo.travel.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findRouteCountByCid(int cid) {

        String sql = "select count(*) from tab_route where cid = ?";
        Integer count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, cid);
        } catch (DataAccessException e) {
//            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Route> findPageRoutes(int cid, int start, int pageSize) {

        String sql = "select * from tab_route where cid = ? limit ?, ?";
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);
    }
}
