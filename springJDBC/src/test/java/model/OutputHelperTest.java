package model;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:24
 * @Description: 测试OutputHelper Bean
 */
public class OutputHelperTest {
    @Test
    public void testOutputHelper() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        OutputHelper helper = (OutputHelper) context.getBean("outputHelper");
        helper.generateOutput();
    }
}