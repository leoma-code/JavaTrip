package cn.leo.travel.service.impl;

import cn.leo.travel.dao.CategoryDao;
import cn.leo.travel.dao.impl.CategoryDaoImpl;
import cn.leo.travel.domain.Category;
import cn.leo.travel.service.CategoryService;
import cn.leo.travel.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        // 对分类数据使用Redis缓存优化
        Jedis jedis = JedisUtils.getJedis();
        Set<String> categories = jedis.zrange("category", 0, -1);

        List<Category> categoryList = null;
        if (categories == null || categories.size() == 0) {
            System.out.println("从数据库中中加载数据。。。");

            // 从数据库中查询分类
            categoryList = categoryDao.findAll();
            // 将数据缓存到Redis中
            for (Category c : categoryList) {
                jedis.zadd("category", c.getCid(), c.getCname());
            }
        } else {
            // 将redis中分类数据存入list
            System.out.println("从Redis中加载数据。。。");

            categoryList = new ArrayList<Category>();

            for (String name : categories) {
                Category category = new Category();
                category.setCname(name);
                categoryList.add(category);
            }
        }

        return categoryList;
    }
}
