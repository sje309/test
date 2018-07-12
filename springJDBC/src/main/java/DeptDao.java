import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 10:44
 * @Description:
 */
public class DeptDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //public DeptDao(JdbcTemplate jdbcTemplate) {
    //    this.jdbcTemplate = jdbcTemplate;
    //}

    //使用jdbc模板工具类简化jdbc操作
    public void save() {
        String sql = "insert into dept(deptName) values ('test1');";
        int result = jdbcTemplate.update(sql);
        if (result > 0) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
    }

    //DeptService事务调用的保存方法
    public void saveByTransaction(Dept dept) {
        String sql = "insert into dept(deptName) values (?)";
        int result = jdbcTemplate.update(sql, dept.getDeptName());
        if (result > 0) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
    }

    public Dept findById(int id) {
        String sql = "select * from dept where deptId=?";
        List<Dept> list = jdbcTemplate.query(sql, new MyResult(), id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    public List<Dept> getAll() {
        String sql = "select * from dept";
        List<Dept> list = jdbcTemplate.query(sql, new MyResult());
        return list;
    }
}

/**
 * 数据库一行数据记录封装为对象
 */
class MyResult implements RowMapper<Dept> {
    @Override
    public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
        Dept dept = new Dept();
        dept.setDeptId(resultSet.getInt("deptId"));
        dept.setDeptName(resultSet.getString("deptName"));
        return dept;
    }
}
