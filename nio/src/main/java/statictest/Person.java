package statictest;

/** @Author: shuyizhi @Date: 2018-08-08 9:50 @Description: */
public class Person {
    /* String name;
    int age;

    @Override
    public String toString() {
        return "Name: " + name + ",Age: " + age;
    }

    public static void main(String[] args) {
        Person p1=new Person();
        p1.name="zhangsan";
        p1.age=10;

        Person p2=new Person();
        p2.name="lisi";
        p2.age=12;

        System.out.println(p1);
        System.out.println(p2);
    }*/

    // private static int count = 0;
    // int id;
    // String name;
    // int age;
    //
    // public Person() {
    //    id = ++count;
    // }
    //
    // @Override
    // public String toString() {
    //    return "Id: " + id + ",Name: " + name + ",Age: " + age;
    // }
    //
    // public static void main(String[] args) {
    //    Person p1 = new Person();
    //    p1.name = "zhangsan";
    //    p1.age = 10;
    //
    //    Person p2 = new Person();
    //    p2.name = "lisi";
    //    p2.age = 12;
    //
    //    /** 输出:Id:1,Name:zhangsan,Age:10 */
    //    System.out.println(p1.toString());
    //    /** 输出: Id:2,Name:lisi,Age:12 */
    //    System.out.println(p2.toString());
    // }

    Book book1 = new Book("book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");

    public Person(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4 = new Book("static成员book4成员变量初始化");

    public static void main(String[] args) {
        Person p1 = new Person("p1初始化");
    }
}

class Book {
    public Book(String msg) {
        System.out.println(msg);
    }
}
