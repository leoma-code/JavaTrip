package cn.leo.travel.dao;

import java.util.List;

/**
 * Created by Leo on 2020/3/5.
 * Description :
 */
public interface RouteImgDao {

    /**
     * 根据线路ID查询线路图片
     * @param rid
     * @return
     */
    public List findRouteImgsByRid(int rid);
}
