package bean;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-16 9:19
 * @Description:
 */
public class PersonBean {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

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
        return "PersonBean[" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ']';
    }
}
