package stringtest;

/**
 * @Author: shuyizhi @Date: 2018-08-15 14:12 @Description:局部内部类
 * 参考：https://www.cnblogs.com/SQP51312/p/6108848.html 1、内部类不能被public、private、static修饰；
 * 2、在外部类中不能创建内部类的实例； 3、创建内部类的实例只能在包含他的方法中； 4、内部类访问包含他的方法中的变量必须有final修饰；(Java8没有此限制)
 * 5、外部类不能访问局部内部类，只能在方法体中访问局部内部类，且访问必须在内部类定义之后。
 */
public class Outer {
    private String s1 = "This is s1 in Outer";
    private String s_outer = "This is s_outer in Outer";

    private String method1() {
        return "This is method1 in Outer";
    }

    private String method2() {
        return "This is method2 in Outer";
    }

    public void method3() {
        // String s_method = "This is s_method in method3";
        final String s_method = "This is s_method in method3";
        class Inner {
            private String s1 = "This is s1 in Inner";

            public void method1() {
                /** 内部类访问外部方法的变量，外部变量需要final修饰 */
                System.out.println("s_method: " + s_method);

                /** 局部内部类可直接访问外部类的变量，即使是私有的 */
                System.out.println("s_outer: " + s_method);

                /** 局部内部类访问同名变量 */
                System.out.println("内部类的s1: " + s1);
                System.out.println("外部类的s1: " + Outer.this.s1);

                /** 访问局部内部类的方法 */
                System.out.println(method2());

                /** 局部内部类访问外部的方法 */
                System.out.println(Outer.this.method2());
            }

            private String method2() {
                return "This is method2 in Inner";
            }
        }

        Inner inner = new Inner();
        inner.method1();
    }
}
