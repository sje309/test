/**
 * @Author: shuyizhi @Date: 2018-08-14 11:39 @Description: 创建静态内部类和非静态内部类
 * 参考：https://www.cnblogs.com/muffe/p/6580208.html
 */
class OuterClass {
    private static String msg = "GeeksForGeeks";
    private String msg1 = "GeekForGeeks Message1";

    public static class NestedStaticClass {
        public void printMessage() {
            System.out.println("Message from nested static class: " + msg);
        }
    }

    public class InnerClass {
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
            System.out.println("Message from non-static nested class: " + msg1);
        }
    }
}

class Main {
    public static void main(String[] args) {
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printMessage();
    }
}
