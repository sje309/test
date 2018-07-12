package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 14:24
 * @Description:
 */
public class AppTest {
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext("xml/bean.xml");

    public static void main(String[] args) {
        //testApp();
        testCglib();
    }

    //目标对象有接口实现，spring会自动选择"JDK代理"
    public static void testApp() {
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        System.out.println(userDao.getClass());     //class com.sun.proxy.$Proxy2
        userDao.save();
    }

    //目标对象没有实现接口，spring会用"CGLib代理"
    public static void testCglib() {
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
    }
}
