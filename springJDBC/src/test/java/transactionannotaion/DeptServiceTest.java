package transactionannotaion;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 10:01
 * @Description:
 */
public class DeptServiceTest {

    @Test
    public void save() {
        //容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("txAnnotaionBean.xml");
        //模拟数据
        Dept dept = new Dept();
        dept.setDeptName("开发部2");
        DeptService deptService = (DeptService) context.getBean("deptService");
        deptService.save(dept);
    }
}