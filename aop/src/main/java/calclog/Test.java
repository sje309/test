package calclog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 16:25
 * @Description:
 */
public class Test {
    static ApplicationContext context =
            new ClassPathXmlApplicationContext("calclog/bean.xml");

    public static void main(String[] args) {
        //testAdd();
        testDiv();
    }

    public static void testAdd() {
        int i = 10, j = 10;
        Calculator calculator = (Calculator) context.getBean("calculatorImpl");
        System.out.println("calculator.Add(10,10): " + calculator.add(i, j));
    }

    public static void testDiv() {
        int i = 10, j = 0;
        Calculator calculator = (Calculator) context.getBean("calculatorImpl");
        System.out.println("calculator.Div(10,0): " + calculator.div(i, j));        //java.lang.ArithmeticException: / by zero
    }
}
