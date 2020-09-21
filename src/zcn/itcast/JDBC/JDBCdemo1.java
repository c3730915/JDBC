package zcn.itcast.JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
            String sql = "update user set password = 9990 where id = 1 ";
            //获取执行对象statement
             statement = connection.createStatement();
            //执行sql
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            //释放资源
            if (count>0)
            {
                System.out.println("Successfully");
            }else {
                System.out.println("Failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //导入驱动jar包，注册驱动
       finally {
            connection.close();
            statement.close();


        }

    }
}
