package transactionannotaion;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 17:28
 * @Description:
 */
@Repository  //把DeptDao加入容器
public class DeptDao {
    @Resource  //获取容器对象
    private JdbcTemplate jdbcTemplate;

    public void save(Dept dept) {
        String sql = "insert into dept (deptName) values (?);";
        jdbcTemplate.update(sql, dept.getDeptName());
    }
}
