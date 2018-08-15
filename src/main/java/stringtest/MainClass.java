package stringtest;

/** @Author: shuyizhi @Date: 2018-08-15 14:41 @Description: */
public class MainClass {
    public static void main(String[] args) {
        // Outer outer = new Outer();
        // outer.method3();

        StaticInnerClass outer = new StaticInnerClass();
        System.out.println("===========================外部类测试===============================");
        outer.method1();

        System.out.println("===========================内部类测试===============================");
        StaticInnerClass.Inner inner = new StaticInnerClass.Inner();
        inner.method1();
    }
}
