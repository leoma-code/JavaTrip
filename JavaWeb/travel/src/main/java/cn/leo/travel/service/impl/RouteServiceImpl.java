package cn.leo.travel.service.impl;

import cn.leo.travel.dao.RouteDao;
import cn.leo.travel.dao.RouteImgDao;
import cn.leo.travel.dao.SellerDao;
import cn.leo.travel.dao.impl.RouteDaoImpl;
import cn.leo.travel.dao.impl.RouteImgDaoImpl;
import cn.leo.travel.dao.impl.SellerDaoImpl;
import cn.leo.travel.domain.PageBean;
import cn.leo.travel.domain.Route;
import cn.leo.travel.domain.Seller;
import cn.leo.travel.service.RouteService;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> queryRoutes(int cid, String rname, int currentPage, int pageSize) {

        PageBean<Route> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);

        int count = routeDao.findRouteCountByCid(cid, rname);
        pageBean.setTotalSize(count);

        int totalPage = count % pageSize == 0 ? (count / pageSize) : (count / pageSize) + 1;
        pageBean.setTotalPage(totalPage);

        if (count > 0) {
            int start = (currentPage - 1) * pageSize;
            List<Route> list = routeDao.findPageRoutes(cid, rname, start, pageSize);
            pageBean.setList(list);
        }

        return pageBean;
    }

    @Override
    public Route findOne(int rid) {

        Route route = routeDao.findOneByRid(rid);

        List routeImgList = routeImgDao.findRouteImgsByRid(rid);
        route.setRouteImgList(routeImgList);

        Seller seller = sellerDao.findSellerBySid(route.getSid());
        route.setSeller(seller);

        return route;
    }
}
