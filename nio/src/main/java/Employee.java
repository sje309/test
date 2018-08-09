/** @Author: shuyizhi @Date: 2018-08-08 11:06 @Description: */
public class Employee {
    private String name;
    private int age;
    private static final int LEN = 8;

    public Employee() {}

    public Employee(String name, int age) {
        if (name.length() > LEN) {
            name = name.substring(0, 8);
        } else {
            while (name.length() < LEN) {
                name = name + "\u0000";
            }
        }
        this.age = age;
        this.name = name;
    }

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

    public static int getLEN() {
        return LEN;
    }
}
