package web_first.day02_JDBC.DatabaseConnectionPool;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 【在这里无法导入test4的工具，无法使用注解测试@test】
 *
 * 练习：
 *      【DML语句】
 *      1.修改一号数据的salary为10000
 *      2.添加一条记录
 *      3.删除刚才添加的记录
 *      【DQL语句】
 *      4.查询id为1的记录，将其封装为Map集合
 *      5.查询所有记录，将其封装为list
 *      6.查询所有记录，将其封装为Emp对象的List集合
 *      7.查询总记录数
 */
public class JDBCTemplate_Test2 {

    public static void main(String[] args) {

    }

    // 获取JdbcTemplate对象
    public static JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataBase());

    //1.修改一号数据的salary为10000
    public static void test1() {
        //修改一号数据的salary为10000
        String sql = "update emp set salary = 10000 where id = 1001";
        //执行sql
        int count = jt.update(sql, 3);
        System.out.println(count);
    }

    //2.添加一条记录
    public static void test2() {
        //添加一条记录
        String sql = "insert into emp(id, salary) values( 1015, 3000)";
        //执行sql
        int count = jt.update(sql, 3);
        System.out.println(count);
    }

    //3.删除刚才添加的记录
    public static void test3() {
        //删除刚才添加的记录
        String sql = "delete from emp where id = ?";
        // 执行sql
        int count = jt.update(sql, 3);
        System.out.println(count);
    }

    //4.查询id为1的记录，将其封装为Map集合
    //【注意】此方法查询的结果集长度只能是1
    public static void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = jt.queryForMap(sql, 1001);
        System.out.println(map);
    }

    //5.查询所有记录，将其封装为list
    //【注意】此方法是：将数据封装成一条一条的Map，再将Map封装到List集合中
    public static void test5() {
        String sql = "select * from emp";
        List<Map< String, Object>> list = jt.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    //6.查询所有记录，将其封装为Emp对象的List集合
    //【注意】用此方法，必须将所有的数据类型改为包装类：int -> Integer , double -> Double
    public static void test6() {
        String sql = "select * from emp";
        List<Emp> list = jt.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    //7.查询总记录数
    public static void test7() {
        String sql = "select count(id) from emp";
        Long total = jt.queryForObject( sql, Long.class);
        System.out.println(total);
    }
}


//定义一个员工类
class Emp {
    private Integer id;
    private String name;
    private Integer job_id;
    private Date joinDay;
    private Double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Date getJoinDay() {
        return joinDay;
    }

    public void setJoinDay(Date joinDay) {
        this.joinDay = joinDay;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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