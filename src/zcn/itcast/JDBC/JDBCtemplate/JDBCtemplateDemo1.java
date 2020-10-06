package zcn.itcast.JDBC.JDBCtemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import zcn.itcast.JDBC.druid.JDBCUtils;

public class JDBCtemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        //创建JDBCTemplate 对象
//
//        template.update();


    }
}
