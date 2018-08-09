import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/** @Author: shuyizhi @Date: 2018-08-08 11:29 @Description: */
public class RandomAccessFileTestTest {

    @Test
    public void wirteFile() {
        List<Employee> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.setAge(i);
            employee.setName("emp" + i);
            list.add(employee);
        }
        Employee[] employees = new Employee[list.size()];
        list.toArray(employees);
        try {
            RandomAccessFileTest.wirteFile(employees, "D:\\emp.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入成功");
    }

    @Test
    public void readFile() {
        String filePath = "D:\\solrByCommonIO.json";
        try {
            RandomAccessFileTest.readFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
