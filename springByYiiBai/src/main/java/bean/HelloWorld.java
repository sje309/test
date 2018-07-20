package bean;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:47
 * @Description: JavaBean
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 5: Hello! " + name);
    }
}
