package jdbcTemplate;

import dao.StudentDao;
import mapper.StudentMapper;
import model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 14:37
 * @Description:
 */
public class StudentJdbcTemplate implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(String name, Integer age) {
        String sql = "insert into student(name,age) values(?,?);";
        return jdbcTemplate.update(sql, name, age) > 0;
    }

    @Override
    public Student getStudent(Integer id) {
        //region query List方式
        //String sql = "select id,age,name from student where id=?;";
        //List<Student> list = jdbcTemplate.query(sql, new StudentMapper(), 1);
        //return (null != list && list.size() > 0) ? list.get(0) : null;
        //endregion

        String sql = "select id,age,name from student where id=?;";
        Student student = jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
        return student;
    }

    @Override
    public List<Student> listStudents() {
        String sql = "select * from student;";
        return jdbcTemplate.query(sql, new StudentMapper());
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from student where id=?;";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean update(Integer id, Integer age, String name) {
        String sql = "update student set age=?,name=? where id=?; ";
        return jdbcTemplate.update(sql, age, name, id) > 0;
    }
}
