package config;

import model.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:40
 * @Description:
 */
@Configuration
public class AppConfig {
    @Bean(value = "helloBeantest")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}
