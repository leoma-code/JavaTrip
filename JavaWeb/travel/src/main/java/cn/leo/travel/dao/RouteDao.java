package cn.leo.travel.dao;

import cn.leo.travel.domain.Route;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public interface RouteDao {

    /**
     * 根据cid查询路旅游线路数据条数
     * @param cid
     * @return
     */
    public int findRouteCountByCid(int cid, String rname);

    /**
     * 分页查询旅游线路数
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findPageRoutes(int cid, String rname, int start, int pageSize);

    /**
     * 根据ID查询一条线路数据
     * @param rid
     * @return
     */
    public Route findOneByRid(int rid);
}
