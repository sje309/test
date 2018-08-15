package stringtest;

/**
 * @Author: shuyizhi @Date: 2018-08-15 15:04 @Description: 内部静态类
 * 参考：https://www.cnblogs.com/SQP51312/p/6102620.html
 * 1、创建静态内部类方式：Outer.Inner inner = new Outer.Inner()；静态内部类不依赖于外部类。
 *2、外部类可通过内部类的对象调用内部类的私有成员变量或方法。
 *3、静态内部类访问外部类的静态成员变量或方法必须是静态的。
 *4、静态内部类中可定义静态的成员变量和方法。
 *5、外部类可以创建静态内部类的实例，即使是私有的；并可通过内部类的实例访问内部类的成员变量和方法，即使是私有的。
 */
public class StaticInnerClass {
    private static String s1 = "This is s1 in Outer";
    private static String s2 = "This is s2 in Outer";

    public void method1() {
        /** 外部类可以通过内部类的对象调用内部类的私有非静态成员变量或方法 */
        System.out.println("内部类的s1: " + new Inner().s1);
        System.out.println("内部类的method2方法: " + new Inner().method2());

        /** 外部类通过内部类名称访问私有静态成员变量或方法 */
        System.out.println("内部类的s3: " + Inner.s3);
        System.out.println("内部类的method3方法: " + Inner.method3());
    }

    public static String method2() {
        return "This is method2 in Outer";
    }

    /** 内部静态类 */
    public static class Inner {
        private String s1 = "This is s1 in Inner";
        private static String s3 = "This is s3 in Inner";

        public void method1() {
            /** 静态内部类可以直接访问外部类的私有静态成员变量或方法 */
            System.out.println("外部类的s2: " + s2);

            /** 同名变量的访问 */
            System.out.println("外部类的s1: " + StaticInnerClass.s1);
            System.out.println("内部类的s1: " + s1);

            /** 同名方法的访问 */
            System.out.println("外部类的method1方法: " + StaticInnerClass.method2());
            System.out.println("内部类的method2方法: " + method2());
        }

        private String method2() {
            return "This is method2 in Inner";
        }

        private static String method3() {
            return "This is static method3 in Inner";
        }
    }
}
