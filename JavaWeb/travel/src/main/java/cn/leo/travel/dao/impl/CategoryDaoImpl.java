package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.CategoryDao;
import cn.leo.travel.domain.Category;
import cn.leo.travel.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Leo on 2020/1/17.
 * Description :
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<Category> findAll() {

        List<Category> categoryList = null;
        try {
            String sql = "SELECT * FROM tab_category";
            categoryList = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}
