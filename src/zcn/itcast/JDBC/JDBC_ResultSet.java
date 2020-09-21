package zcn.itcast.JDBC;

import java.sql.*;

public class JDBC_ResultSet {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
            String sql = "select * from user ";
            //获取执行对象statement
            statement = connection.createStatement();
            //执行sql
             resultSet = statement.executeQuery(sql);

            //得到查询结果
            while (resultSet.next()) {                  //游标向下移动一行 指向第一行数据

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                System.out.println(id+"-------"+name);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //导入驱动jar包，注册驱动
        finally {
            connection.close();
            statement.close();
            resultSet.close();


        }

    }
}
