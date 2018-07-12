package dao;

import model.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 14:29
 * @Description:
 */
public interface StudentDao {
    void setDataSource(DataSource ds);

    boolean create(String name, Integer age);

    Student getStudent(Integer id);

    List<Student> listStudents();

    boolean delete(Integer id);

    boolean update(Integer id, Integer age, String name);
}
