package test;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 13:57
 * @Description:
 */
public class Person {
    public static void main(String[] args) {
        //<editor-fold desc="静态初始化">
//        Person p1 = new Person("p1初始化");
        //</editor-fold>

        Person.funStatic();
        System.out.println("**********************");
        Person p1=new Person("p1初始化");
        String str=new String("String类型");
    }

    Book book1 = new Book("book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");

    public Person(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4 = new Book("static成员book4成员变量初始化");

    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }
}
