package jvm;

/** @Author: shuyizhi @Date: 2018/11/5 14:33 @Description: */
public class Person {
    /** 实例变量name和age在堆(Heap)中分配内存 */
    private String name;

    private int age;
    /** 类变量(引用类型)name1和"cn"都在方法区(Method Area) */
    private static String name1 = "cn";
    /** 类变量(引用类型)name2在方法区(Heap)中分配空间 new String("cn")对象在堆(Heap)中分配空间 */
    private static String name2 = new String("cn");
    /** num在堆中,new int[10]也在堆中 */
    private int[] num = new int[10];

    Person(String name, int age) {
        /** this 及形参name、age在构造方法被调用时会在构造方法的栈帧中开辟空间 */
        this.name = name;
        this.age = age;
    }
    /** setName()方法在方法区中 */
    public void setName(String name) {
        this.name = name;
    }
    /** speak()方法在方法区中 */
    public void speak() {
        System.out.println("name: " + this.name + ",age: " + this.age);
    }
}
