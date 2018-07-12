package e_aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 10:05
 * @Description:
 */
public class AppTest {
    static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("e_aop_anno/bean.xml");

    public static void main(String[] args) {
        testApp();
        //testCglig();

        //try {
        //    testGetObj();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }

    //目标对象实现接口，spring会自动选择"JDK代理",UserDao是实现了接口IUserDao的类
    private static void testApp() {
        IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
        System.out.println(userDao.getClass());
        userDao.save();
    }

    //目标对象没有实现接口，spring会用"cglib代理",OrderDao没有实现接口
    public static void testCglig() {
        OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDao");
        System.out.println(orderDao.getClass());        //class e_aop_anno.OrderDao$$EnhancerBySpringCGLIB$$48b985cc
        orderDao.save();
    }

    public static void testGetObj() throws Exception {
        OrderDao orderDao1 = (OrderDao) applicationContext.getBean("orderDao");
        OrderDao orderDao2 = (OrderDao) applicationContext.getBean("orderDao");
        System.out.println(orderDao1);
        System.out.println(orderDao2);
        System.out.println(orderDao1 == orderDao2);
    }

}
