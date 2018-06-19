package dbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 15:12
 * @Description: 参考: https://blog.csdn.net/yerenyuan_pku/article/details/52389162
 */
public class DepartmentDao {
    public static void add(Department department) throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into department(id,name) values(?,?)";
        Object[] params = {department.getId(), department.getName()};
        runner.update(sql, params);
        Set<Employee> set = department.getEmployees();
        for (Employee e : set) {
            sql = "insert into employee(id,name,salary,department_id) values (?,?,?,?)";
            params = new Object[]{e.getId(), e.getName(), e.getSalary(), department.getId()};
            runner.update(sql, params);
        }
    }

    public static Department find() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        //String sql = "select * from department where id=?";
        //Object[] params = {"25b707b8-d309-48f3-ad67-fc90c3760ba6"};
        // 1. 找部门表，查出部门的基本信息
        String sql = "select * from department where id=?";
        Department d = (Department) runner.query(sql, "25b707b8-d309-48f3-ad67-fc90c3760ba6", new BeanHandler(Department.class));
        // 2. 找员工表，找出部门下面所有员工
        sql = "select * from employee where department_id=?";
        List<Employee> list = (List<Employee>) runner.query(sql, "25b707b8-d309-48f3-ad67-fc90c3760ba6", new BeanListHandler(Employee.class));
        d.getEmployees().addAll(list); // addAll()方法取出List集合里面的每一个员工，把每一个员工加到Set集合里面去
        return d;
    }
}
