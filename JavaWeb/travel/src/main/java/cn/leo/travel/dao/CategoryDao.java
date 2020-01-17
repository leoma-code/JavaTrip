package cn.leo.travel.dao;

import cn.leo.travel.domain.Category;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public interface CategoryDao {

    /**
     * 查询所有分类
     * @return
     */
    public List<Category> findAll();
}
