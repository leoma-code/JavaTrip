package cn.leo.travel.dao.impl;

import cn.leo.travel.dao.UserDao;
import cn.leo.travel.domain.User;
import cn.leo.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User findByUsername(String username) {

        User user = null;
        try {
            String sql = "select * from tab_user where username = ?";
            // 查不到user会报异常
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {

        }
        return user;
    }

    @Override
    public void save(User user) {

        String sql = "insert into tab_user (username, password, name, birthday, sex, telephone, email) " +
                "values(?,?,?,?,?,?,?)";

        template.update(sql, user.getUsername(),
                user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(),
                user.getTelephone(), user.getEmail());

    }
}
