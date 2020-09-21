package zcn.itcast.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demo_list_result_object {
    /*
    查询所有emp对象
    @return
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Emp> list = new demo_list_result_object().findAll();
        System.out.println(list);
    }
    public List<Emp> findAll() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
       String sql = "Select * from emp";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Emp emp = null;
        List<Emp> list = new ArrayList<Emp>();
        while (resultSet.next()) {
            //获取数据
            int id = resultSet.getInt("id");
            String ename = resultSet.getString("ename");
            int job_id = resultSet.getInt("job_id");
            int mgr = resultSet.getInt("mgr");
            Date joindate = resultSet.getDate("joindate");
            double salary = resultSet.getDouble("salary");
            double bouns = resultSet.getDouble("bouns");
            int dept_id = resultSet.getInt("dept_id");
            emp = new Emp();
            emp.setId(job_id);
            emp.setEname(ename);
            emp.setJob_id(job_id);
            emp.setMgr(mgr);
            emp.setJoindate(joindate);
            emp.setSalary(salary);
            emp.setBouns(bouns);
            emp.setDept_id(dept_id);
            list.add(emp);

        }
        statement.close();
        connection.close();
        resultSet.close();

        return list;
    }
}
