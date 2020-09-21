package zcn.itcast.JDBC.util;

import java.sql.*;
import java.util.Scanner;

public class Login_Utils {
    public boolean login(String username,String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet =null;
        PreparedStatement preparedStatement =null;
        try {
            if (username == null || password == null) {
                return false;
            }
            connection = JDBCUtils.getConnection();
//            String sql = "select * from user where name = '"+username+"'and password = '"+password+"'"; // 注意单引号,缺点容易被sql注入！！


            String sql = "select * from user where name = ? and password = ? "; // 注意单引号
            preparedStatement = connection.prepareStatement(sql);
            //获取执行sql的对象
            preparedStatement.setString(1,username);
            preparedStatement.setString(1,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return false;


    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        boolean flag = new Login_Utils().login(username, password);
        System.out.println(flag);


    }
}
