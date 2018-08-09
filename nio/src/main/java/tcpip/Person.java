package tcpip;

import java.io.Serializable;

/** @Author: shuyizhi @Date: 2018-08-09 11:08 @Description: */
public class Person implements Serializable {
    private static final long serialVersionUID = -6183263346917007116L;
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='"
                + name
                + '\''
                + ", age="
                + age
                + ", address='"
                + address
                + '\''
                + '}';
    }
}
