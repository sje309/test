package stringtest;

/** @Author: shuyizhi @Date: 2018-08-15 9:31 @Description: */

/** 输出:base static test static base constructor test constructor */
// public class Test extends Base {
//    static {
//        System.out.println("test static");
//    }
//
//    public Test() {
//        System.out.println("test constructor");
//    }
//
//    public static void main(String[] args) {
//        new Test();
//    }
// }
//
// class Base {
//    static {
//        System.out.println("base static");
//    }
//
//    public Base() {
//        System.out.println("base constructor");
//    }
// }

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}

class MyClass extends Test {
    Person person = new Person("MyClass");

    static {
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

public class Test {
    Person person = new Person("Test");

    static {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
    /** test static myclass static person static person MyClass */
}
