package bean;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 17:21
 * @Description: 构造器注入
 * 参考：https://www.yiibai.com/spring/constructor-injection-type-ambiguities-in-spring.html#article-start
 */
public class Customer {
    private String name;
    private String address;
    private int age;

    public Customer(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Customer(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n address: " + address + "\n age: " + age;
    }
}
