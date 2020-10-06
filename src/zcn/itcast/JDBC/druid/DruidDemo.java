package zcn.itcast.JDBC.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

//druid demo
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        Properties properties = new Properties(); //加载配置文件
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        //创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
