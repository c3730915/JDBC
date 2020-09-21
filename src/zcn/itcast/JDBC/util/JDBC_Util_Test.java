package zcn.itcast.JDBC.util;

import java.sql.*;

public class JDBC_Util_Test {
    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;
        Connection connection =null;
        try {
            String sql = "select * from user ";
            connection = JDBCUtils.getConnection();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(statement,connection);
        }

    }
}
