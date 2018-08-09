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

    /** 测试以为运算 */
    @Test
    public void testOperator() {
        int number = 10;
        // printInfo(number);

        number = number << 8;
        // printInfo(number);
        System.out.println(number);

        number = number >> 1;
        System.out.println(number);
        // printInfo(number);
    }

    /**
     * 输出Integer二进制表示
     *
     * @param num
     */
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
