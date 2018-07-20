package model;

import config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:12
 * @Description:
 */
public class HelloWorldTest {
    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        //调用obj的方法
        obj.printHello();
    }

    @Test
    public void testBeanByAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld obj = (HelloWorld) context.getBean("helloBeantest");
        obj.printHello();
    }
}