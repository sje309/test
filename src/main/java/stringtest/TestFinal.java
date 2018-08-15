package stringtest;

/** @Author: shuyizhi @Date: 2018-08-15 15:46 @Description: */
public class TestFinal {
    public static void main(String[] args) {

        // MyTestClass myClass1 = new MyTestClass();
        // MyTestClass myClass2 = new MyTestClass();
        //
        // System.out.println("================myclass1====================");
        // System.out.println("i: " + myClass1.i);
        // System.out.println("j: " + MyTestClass.j);
        //
        // System.out.println("================myclass2====================");
        // System.out.println("i: " + myClass2.i);
        // System.out.println("j: " + MyTestClass.j);

        MyTestClass1 myTestClass1 = new MyTestClass1();
        StringBuffer buffer = new StringBuffer("hello");
        myTestClass1.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyTestClass {
    public final double i = Math.random();
    public static double j = Math.random();
}

class MyTestClass1 {
    void changeValue(StringBuffer buffer) {
        buffer.append("world");
    }
}
