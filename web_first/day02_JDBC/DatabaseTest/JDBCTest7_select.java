package web_first.day02_JDBC.DatabaseTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询所有员工的信息，要求这些信息被封装到一个集合中再返回
 */
public class JDBCTest7_select {

    public static void main(String[] args) {
        //测试所写的方法
        List<Emp> list = new JDBCTest7_select().findAll();
        System.out.println(list);
    }

    //查询所有的对象，并存储在一个集合中返回
    public List<Emp> findAll() {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        ArrayList<Emp> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            // 3.定义sql语句
            String sql = "create table course( id int, name varchar(20))";
            // 4.获取执行sql的对象
            stat = con.createStatement();
            // 5.执行sql语句
            rs = stat.executeQuery(sql);
            //6.定义一个集合。用于存储对象
            list = new ArrayList<Emp>();
            Emp emp = null;
            // 7.处理结果
            while(rs.next()) {
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("name");
                int joy_id = rs.getInt("joy_id");
                Date joinDay = rs.getDate("joinDay");
                double salary = rs.getDouble("salary");

                emp = new Emp();
                emp.setId(id);
                emp.setName(ename);
                emp.setJob_id(joy_id);
                emp.setJoinDay(joinDay);
                emp.setSalary(salary);

                //装载集合
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //8.释放资源
            if( rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if( stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}


//定义一个员工类
class Emp {
    private int id;
    private String name;
    private int job_id;
    private Date joinDay;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public Date getJoinDay() {
        return joinDay;
    }

    public void setJoinDay(Date joinDay) {
        this.joinDay = joinDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job_id=" + job_id +
                ", joinDay=" + joinDay +
                ", salary=" + salary +
                '}';
    }
}