package mapper;

import model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 14:33
 * @Description: 数据库实体映射
 */
public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setAge(resultSet.getInt("age"));
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        return student;
    }
}
