package com.leo.datasource.jdbctemplate;

import com.leo.datasource.domain.Emp;
import com.leo.datasource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Leo on 2020/1/6.
 * Description :
 */
public class JDBCTemplateDemo {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1. 修改1号数据的 salary 为 10000
     */
    @Test
    public void test1() {
        String sql = "update emp set salary = 10000 where id = 1001";
        int update = template.update(sql);
        System.out.println("update - " + update);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp (id, ename, dept_id) values (?, ?, ?)";
        int insert = template.update(sql, 1015, "张三疯", 10);
        System.out.println("insert - " + insert);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int delete = template.update(sql, 1015);
        System.out.println("delete - " + delete);
    }

    /**
     * 4.查询id为1001的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }


    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> mapList = template.queryForList(sql);
        System.out.println(mapList);
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6_1(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });


        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6_2() {
        String sql = "select * from emp";

        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        for (Emp emp: list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数
     */
    @Test
    public void test7() {
        String sql = "select count(*) from emp";

        Long total = template.queryForObject(sql, Long.class);

        System.out.println(total);
    }




    /**
     * JdbcTemplate 更新操作
     */
    @Test
    public void testUpdate() {
        JdbcTemplate tem = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "update account set balance = 5000 where id = ?";

        int update = tem.update(sql, 3);

        System.out.println("update - " + update);
    }

}
