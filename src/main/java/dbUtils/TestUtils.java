package dbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** @Author: shuyizhi @Date: 2018/4/3 17:02 @Description: */

/**
 * ArrayHandler：把结果集中的第一行数据转成对象数组。 ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
 * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
 * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。 ColumnListHandler：将结果集中某一列的数据存放到List中。
 * KeyedHandler：将结果集中的每一行数据都封装到一个Map里，然后再根据指定的key把每个Map再存放到一个Map里。
 * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
 * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List。 ScalarHandler：将结果集中某一条记录的其中某一列的数据存成Object
 */
public class TestUtils {
    public static void main(String[] args) {
        // System.out.println(insert() == true ? "插入成功!" : "插入失败!");
        // System.out.println(update() == true ? "更新成功!" : "更新失败!");
        // System.out.println(delete() == true ? "删除成功!" : "删除失败");

        // UsersBean usersBean = findUser();
        // if (null != usersBean) {
        //    System.out.println(usersBean.toString());
        // }

        // try {
        //    batchInsert();
        // } catch (SQLException e) {
        //    e.printStackTrace();
        // }

        // List<UsersBean> list = findUsersByParams();
        //// list = findUsers();
        // if (null != list && !list.isEmpty()) {
        //    for (UsersBean bean : list) {
        //        System.out.println(bean.toString());
        //    }
        // }

        // List<String> list = findColumn();
        // String result = String.join("\t", list);
        // System.out.println(result);
        // if (null != list && !list.isEmpty()) {
        //    for (String s : list) {
        //        System.out.println(s);
        //    }
        // }

        // testMap();

        // region 一对多关联
        // Department department = new Department();
        // department.setId(UUID.randomUUID().toString());
        // department.setName("部门一");
        // Set<Employee> set = new HashSet<>();
        // for (int i = 0; i < 5; i++) {
        //    Employee employee1 = new Employee();
        //    employee1.setDepartment(department);
        //    employee1.setId(UUID.randomUUID().toString());
        //    employee1.setName("员工" + i);
        //    employee1.setSalary(500.00 * (i + 1));
        //    set.add(employee1);
        // }
        // department.setEmployees(set);
        //
        // try {
        //    DepartmentDao.add(department);
        // } catch (SQLException e) {
        //    e.printStackTrace();
        // }

        //try {
        //    Department department = DepartmentDao.find();
        //    if (null != department) {
        //        System.out.println(department.getName());
        //    }
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
        // endregion

        insert();

    }

    public static boolean insert() {
        String sql = "insert into users1 (id,name,password,email,birthday) values(?,?,?,?,?)";
        Object[] params = {2, "shuyizhi", "123456", "shuyizhi@zxsoft.com.cn", new java.util.Date()};
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

        int n = 0;
        try {
            n = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean update() {
        String sql = "update users set name=?,email=? where id=?";
        Object[] params = {"songli", "songli@zxsoft.com.cn", 2};
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        int n = 0;
        try {
            n = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean delete() {
        String sql = "delete from users where id=?";
        Object[] params = {2};
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        int n = 0;
        try {
            n = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static UsersBean findUser() {
        String sql = "select * from users where id=? and name=?";
        Object[] params = {2, "shuyizhi"};
        UsersBean bean = null;
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        try {
            bean = runner.query(sql, params, new BeanHandler<UsersBean>(UsersBean.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static boolean batchInsert() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
        Object[][] params = new Object[3][5];
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[] {i + 1, "aa" + i, "123", i + "@sian.com", new Date()};
        }
        int[] res = runner.batch(sql, params);
        return res.length > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static List<UsersBean> findAllUsers() {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        List lists = null;
        try {
            lists = runner.query(sql, new BeanListHandler<UsersBean>(UsersBean.class));
            // runner.query(sql, new ArrayListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    /**
     * 使用like
     *
     * @return
     */
    public static List<UsersBean> findUsersByParams() {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        // String sql = "select * from users where name like 'aa%'";
        String sql = "select * from users where name like ?";
        List<UsersBean> beanList = null;
        Object[] params = {"aa%"};
        try {
            beanList = runner.query(sql, new BeanListHandler<UsersBean>(UsersBean.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beanList;
    }

    public static List<String> findColumn() {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        List<String> list = null;
        try {
            list = runner.query(sql, new ColumnListHandler<String>("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void testMap() {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        try {
            Map<Integer, Map<String, Object>> map =
                    (Map<Integer, Map<String, Object>>) runner.query(sql, new KeyedHandler("id"));
            for (Map.Entry<Integer, Map<String, Object>> me : map.entrySet()) {
                int id = me.getKey();
                for (Map.Entry<String, Object> entry : me.getValue().entrySet()) {
                    String name = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(name + "=" + value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
