package zcn.itcast.JDBC.util;

import zcn.itcast.JDBC.Emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Use_Utils {
    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement =null;
        ResultSet resultSet = null;
        List list = null;
        String sql = "select * from emp";

       try {
           connection = JDBCUtils.getConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);
           Emp emp = null;
           list = new ArrayList<Emp>();
           while (resultSet.next()) {

               int id = resultSet.getInt("id");
               String ename = resultSet.getString("ename");
               int job_id = resultSet.getInt("job_id");
               int mgr = resultSet.getInt("mgr");
               Date joindate = resultSet.getDate("joindate");
               double salary = resultSet.getDouble("salary");
               double bouns = resultSet.getDouble("bouns");
               int dept_id = resultSet.getInt("dept_id");
               // 创建emp对象,并赋值
               emp = new Emp();
               emp.setId(id);
               emp.setEname(ename);
               emp.setJob_id(job_id);
               emp.setMgr(mgr);
               emp.setJoindate(joindate);
               emp.setSalary(salary);
               emp.setBouns(bouns);
               emp.setDept_id(dept_id);
               list.add(emp);//把集合加入list中
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
       finally {
           JDBCUtils.close(resultSet,statement,connection);
       }
        System.out.println(list);

    }
}
