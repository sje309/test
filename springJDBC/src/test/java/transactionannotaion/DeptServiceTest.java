package transactionannotaion;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @Author: shuyizhi @Date: 2018-07-13 10:01 @Description: */
public class DeptServiceTest {

    @Test
    public void save() {
        // 容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("txAnnotaionBean.xml");
        // 模拟数据
        Dept dept = new Dept();
        dept.setDeptName("开发部2");
        DeptService deptService = (DeptService) context.getBean("deptService");
        deptService.save(dept);
    }

    @Test
    public void testSubString() {
        String strInput = "P20190123002";
        strInput = strInput.substring(strInput.length() - 3);
        Integer strInteger = Integer.parseInt(strInput) + 1;
        System.out.println("strInput: " + strInput);
        System.out.println("strInteger: " + strInteger);
    }

    @Test
    public void testString() {
        double d = 1100.00;
        boolean b = true;
        long l = 1234567890;
        char[] arr = {'r', 'u', 'n', 'o', 'o', 'b'};

        System.out.println("返回值 : " + String.valueOf(d));
        System.out.println("返回值 : " + String.valueOf(b));
        System.out.println("返回值 : " + String.valueOf(l));
        System.out.println("返回值 : " + String.valueOf(arr));
    }
}
