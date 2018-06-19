package rmi;

import test.Person;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 16:23
 * @Description:
 */
public class PersonClient {
    public static void main(String[] args) {
        try {
            IPerson person = new Person_Stub();
            int age = person.getAge();
            String name = person.getName();
            System.out.println(name + " is " + age + " years old");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
