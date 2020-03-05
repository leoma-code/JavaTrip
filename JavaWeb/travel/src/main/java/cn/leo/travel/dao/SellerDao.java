package cn.leo.travel.dao;

import cn.leo.travel.domain.Seller;

/**
 * Created by Leo on 2020/3/5.
 * Description :
 */
public interface SellerDao {

    /**
     * 查询卖家信息
     * @param sid
     * @return
     */
    public Seller findSellerBySid(int sid);
}
