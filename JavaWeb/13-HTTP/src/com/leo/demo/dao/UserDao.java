package com.leo.demo.dao;

import com.leo.demo.domain.User;
import com.leo.demo.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param loginUser 只有用户名、密码
     * @return 返回用户所有信息
     */
    public User login(User loginUser) {

        try {

            String sql = "select * from user where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }

    }
}
