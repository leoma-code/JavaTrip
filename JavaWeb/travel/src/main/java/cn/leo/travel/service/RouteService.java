package cn.leo.travel.service;

import cn.leo.travel.domain.PageBean;
import cn.leo.travel.domain.Route;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public interface RouteService {

    /**
     * 查询分页数据
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> queryRoutes(int cid, int currentPage, int pageSize);

}
