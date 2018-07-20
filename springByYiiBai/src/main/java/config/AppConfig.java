package config;

import bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 15:22
 * @Description:
 */
@Configuration
public class AppConfig {
    @Bean(value = "helloBeanByAnnotation")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}
