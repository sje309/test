/**
 * @Author: shuyizhi @Date: 2018-08-06 9:43 @Description: JVM String处理
 * 参考：https://blog.csdn.net/buyaoshuohua1/article/details/77337750
 * https://blog.csdn.net/yabay2208/article/details/71548940
 */
public class StringTest {
    public static void main(String[] args) {
        // testString1();
        // changeString();
        // testBasic();

        testInt();
    }

    public static void testString1() {
        String name = "小学徒";
        System.out.println(System.identityHashCode(name));
        name = name + "的成长空间";
        System.out.println(System.identityHashCode(name));
    }

    public static void changeString() {

        /** 输出： a==b: true b==c: true a==c: true */
        /*  String a = "helloWorld";
        String b = "helloWorld";
        String c = "hello" + "World";

        System.out.println("a==b: " + (a == b));
        System.out.println("b==c: " + (b == c));
        System.out.println("a==c: " + (a == c));*/

        /** 输出：a==b: false b==c: false a==c: false */
        // String a = "helloWorld";
        // String b = new String("helloWorld");
        // String c = "hello" + new String("World");
        //
        // System.out.println("a==b: " + (a == b));
        // System.out.println("b==c: " + (b == c));
        // System.out.println("a==c: " + (a == c));

        /** 输出： s1==s2: false s1.equals(s2): true */
        // String s1 = new String("abc");
        // String s2 = new String("abc");
        // System.out.println("s1==s2: " + (s1 == s2));
        // System.out.println("s1.equals(s2): " + s1.equals(s2));

        /** c==c2: true c==c3: false */
        String c = "c2";
        final int cc = 2;
        int cc1 = 2;
        String c2 = "c" + cc;
        String c3 = "c" + cc1;
        System.out.println("c==c2: " + (c == c2));
        System.out.println("c==c3: " + (c == c3));

        String str1 = "abc";
        String str2 = "abc";
        String str3 = "a" + "b" + "c";
        String str4 = new String("abc");
        String str5 = new String("abc");

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        System.out.println("str5: " + str5);

        /**
         * 输出：str1==str2: true str2==str3: true str1==str4: false;str1.equals(str4): true
         * str4==str5: false,str4.equals(str5): true
         */
        System.out.println("str1==str2: " + (str1 == str2));
        System.out.println("str2==str3: " + (str2 == str3));

        System.out.println(
                "str1==str4: " + (str1 == str4) + ";str1.equals(str4): " + (str1.equals(str4)));
        System.out.println(
                "str4==str5: " + (str4 == str5) + ",str4.equals(str5): " + str4.equals(str5));
    }

    /** 参考：https://blog.csdn.net/yabay2208/article/details/71108514 */
    public static void testInt() {
        int a1 = 321;
        int b = 789;
        Integer a2 = 321;

        Integer a3 = 123;
        Integer a4 = 123;

        Integer a5 = 789;
        Integer a6 = 789;

        System.out.println("a1==a2: " + (a1 == a2));
        System.out.println("a3==a4: " + (a3 == a4) + ",\t a3.equals(a4): " + a3.equals(a4));
        System.out.println("a5==a6: " + (a5 == a6) + ",\t a5.equals(a6): " + a5.equals(a6));
        System.out.println("a5==b: " + (a5 == b) + ",\t a5.equals(b): " + a5.equals(b));
    }

    public static void testBasic() {
        int a1 = 1;
        int b1 = 1;
        int c1 = 2;
        int d1 = a1 + b1;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(a1 == b1);

        System.out.println(c1 == d1);

        System.out.println(c == d);

        System.out.println(e == f);
    }
}
