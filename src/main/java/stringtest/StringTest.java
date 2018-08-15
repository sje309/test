package stringtest;

/** @Author: shuyizhi @Date: 2018-08-14 15:32 @Description: */
public class StringTest {
    public static void main(String[] args) {
        // String string = "";
        // for (int i = 0; i < 10000; i++) {
        //    string += "hello";
        // }

        /* String a = "hello2";
        final String b = getHello();
        final String b1 = "2";
        String c = b + 2;
        String d = "hello" + b1;

        System.out.println("a==c: " + (a == c));
        System.out.println("a==d: " + (a == d));*/

        /* String a = "hello";
        String b = new String("hello");
        String c = new String("hello");
        String d = b.intern();

        System.out.println("a==b: "+(a==b));
        System.out.println("b==c: "+(b==c));
        System.out.println("b==d: "+(b==d));
        System.out.println("a==d: "+(a==d));*/

        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        System.out.println("i1==i2: " + (i1 == i2) + ",i1.equals(i2): " + i1.equals(i2));
        System.out.println("i3==i4: " + (i3 == i4) + ",i3.equals(i4): " + i3.equals(i4));

        Boolean b1 = false;
        Boolean b2 = false;

        System.out.println("b1==b2: " + (b1 == b2) + ",b1.equals(b2): " + b1.equals(b2));

        Float f1 = 10.0f;
        Float f2 = 10.0f;

        System.out.println("f1==f2: " + (f1 == f2) + ",f1.equals(f2): " + f1.equals(f2));
    }

    public static String getHello() {
        return "hello";
    }
}
