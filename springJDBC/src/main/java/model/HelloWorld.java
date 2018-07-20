package model;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:00
 * @Description: Spring Bean
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 3: Hello World");
    }
}
