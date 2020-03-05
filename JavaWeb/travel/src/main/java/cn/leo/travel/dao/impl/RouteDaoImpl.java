package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.RouteDao;
import cn.leo.travel.domain.Route;
import cn.leo.travel.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findRouteCountByCid(int cid, String rname) {

        String sql = "select count(*) from tab_route where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList<>();

        if (cid != 0) {
            sb.append(" and cid = ?");
            params.add(cid);
        }

        if (rname != null || !StringUtils.isEmpty(rname)) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }

        sql = sb.toString();

        Integer count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, params.toArray());
        } catch (DataAccessException e) {
//            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Route> findPageRoutes(int cid, String rname, int start, int pageSize) {

        String sql = "select * from tab_route where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList<>();

        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }

        if (rname != null || !StringUtils.isEmpty(rname)) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }

        sb.append(" limit ?, ?");

        params.add(start);
        params.add(pageSize);

        sql = sb.toString();

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOneByRid(int rid) {

        String sql = "select * from tab_route where rid = ?";

        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }


}
