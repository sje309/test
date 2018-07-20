package springCheck;

import org.springframework.beans.factory.annotation.Required;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-17 9:38
 * @Description: Spring依赖检查
 */
public class Person {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
