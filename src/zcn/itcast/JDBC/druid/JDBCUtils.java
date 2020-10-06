package zcn.itcast.JDBC.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static {
        //加载配置文件
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Statement statement ,Connection connection) throws SQLException {
        if ((statement !=null)){
            statement.close();
        }

        if ((connection !=null)){
            connection.close();
        }
    }
    public static void close(ResultSet resultSet ,Statement statement, Connection connection) throws SQLException {

        if ((statement !=null)){
            statement.close();
        }

        if ((resultSet !=null)){
            resultSet.close();
        }
        if ((connection !=null)){
            connection.close();
        }

    }
    //获取连接池
    public static DataSource getDs(){
        return ds;
    }
}
