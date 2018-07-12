package jdbcTemplate;

import model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 15:09
 * @Description:
 */
public class StudentJdbcTemplateTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    private StudentJdbcTemplate studentJDBCTemplate = (StudentJdbcTemplate) context.getBean("studentJDBCTemplate");

    @Test
    public void Crate() {
        System.out.println("========================Records Create========================");
        boolean res = Boolean.FALSE;
        studentJDBCTemplate.create("songli", 35);
        studentJDBCTemplate.create("shuyizhi", 35);
        studentJDBCTemplate.create("束糖豆", 3);
    }

    @Test
    public void getStudent() {
        Student student = studentJDBCTemplate.getStudent(1);
        if (null != student) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void listStudents() {
        List<Student> list = studentJDBCTemplate.listStudents();
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void delete() {
        boolean res = studentJDBCTemplate.delete(1);
        if (res) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void update() {
        boolean res = studentJDBCTemplate.update(2, 30, "唐红");
        if (res) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }
}