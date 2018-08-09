/** @Author: shuyizhi @Date: 2018-08-07 10:39 @Description: */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    public Gum() {
        System.out.println("Gum 构造函数");
    }

    static {
        System.out.println("Loading Gum");
    }
}

class Cookie extends CookieSuper {
    public Cookie() {
        System.out.println("Cookie Constructor");
    }

    /** 静态代码块 */
    static {
        System.out.println("Loading Cookie");
    }

    /** 动态代码块 */
    {
        System.out.println("动态代码块");
    }
}

class CookieSuper {
    public CookieSuper() {
        System.out.println("CookieSuper Constructor");
    }

    static {
        System.out.println("Loading CookieSuper");
    }
}

class TestClass {
    /** 私有构造函数不能通过new TestClass()实例化 */
    private TestClass() {
        System.out.println("TestClass私有构造函数");
    }
}

public class SweetShop {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        // print("inside main");
        // new Candy();
        // print("After creating Candy");
        // try {
        //    Class.forName("Gum");
        // } catch (ClassNotFoundException e) {
        //    // e.printStackTrace();
        //    print("Couldn/t find Gum");
        // }
        // print("After Class.forName(\"Gum\")");
        // new Cookie();
        // print("After creating Cookie");

        // try {
        //    Class.forName("Cookie").newInstance();
        // } catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        // } catch (IllegalAccessException e) {
        //    e.printStackTrace();
        // } catch (InstantiationException e) {
        //    e.printStackTrace();
        // }
        //
        // System.out.println("\n==================new Cookie对象===================");
        new Cookie();
        // new Gum();
    }
}
