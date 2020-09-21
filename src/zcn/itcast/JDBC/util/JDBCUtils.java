package zcn.itcast.JDBC.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*
    文件的读取，使用静态代码块
     */
    static {
        //读取文件

        try {
            //获取src路径文件下的方式，classLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties"); //定位文件路径
            String path = res.getPath();//返回字符串路径
            Properties properties = new Properties();
            properties.load(new FileReader(path));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
    }

    /**
     * 释放资源
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public static void close(Statement statement,Connection connection) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection !=null){
            connection.close();
        }

    }

    public static void close(ResultSet resultSet,Statement statement, Connection connection) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection !=null){
            connection.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }

    }

};


