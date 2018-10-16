package factoryMethod;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Properties;

/** @Author: shuyizhi @Date: 2018-10-11 14:34 @Description: 工厂方法测试，通过配置文件来调用 */
public class Test {
    public static void main(String[] args) {
        /** 从properties文件中获取工厂名称 */
        Properties properties = new Properties();
        try {
            properties.load(Test.class.getResourceAsStream("/factoryConfig.properties"));
            String factoryName = properties.getProperty("factoryName");
            if (StringUtils.isNotEmpty(factoryName)) {
                Class c = Class.forName(factoryName);
                IFactory factory = (IFactory) c.newInstance();
                ICoat coat = factory.createCoat();
                coat.showCoat();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
