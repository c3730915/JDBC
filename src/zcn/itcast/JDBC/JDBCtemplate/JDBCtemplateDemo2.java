package zcn.itcast.JDBC.JDBCtemplate;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zcn.itcast.JDBC.druid.JDBCUtils;

import java.util.List;
import java.util.Map;

public class JDBCtemplateDemo2 {

    //Junit单元测试，可以让方法独立执行
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        String sql = "update emp set salary = 12000 where id =1";
        //execute sql
        int count = template.update(sql);
        System.out.println(count);
    }
    public void test2(){
        /**
         * 预编译sql语句
         */
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        String sql2 = "insert into user values(?,?,?)";
        int count2 = template.update(sql2, 1, "hhh", "666");
        System.out.println(count2);
    }
    @Test
    public void test3(){
        /**
         * 查询记录，注意只能是一条记录因为使用Map集合，否则会报错
         */
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        String sql3="select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql3, 1);
        System.out.println(map);

    }
    @Test
    public void test4(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        String sql4 = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql4);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test5()
    {
        String sql5 = "select * from emp";
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        List<Emp> list = template.query(sql5, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }

    }
}
