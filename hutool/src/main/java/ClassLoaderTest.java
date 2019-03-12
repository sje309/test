/**
 * @Author: shuyizhi @Date: 2018/11/5 10:42 @Description: 类加载器
 * 参考：https://www.cnblogs.com/ityouknow/p/5603287.html
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // System.out.println(classLoader);
        // System.out.println(classLoader.getParent());
        // System.out.println(classLoader.getParent().getParent());

        // ClassLoaderTest classLoaderTest = new ClassLoaderTest();

        // new Test();
        // new Test();
        // new Test(3);
        // new Test();
        // new Test(5);
        // Test.count();

        Test test = new Test();
        test.run();
    }
}

class Test {
    int id;
    String name;
    static int sum = 0;

    {
        sum += 1;
    }

    Test() {}

    Test(int id) {}

    static void count() {
        System.out.println(sum);
    }
    /** 局部代码块 */
    void run() {
        {
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
            }
            System.out.println("局部代码块中i已经超出其作用域");
        }
        System.out.println("普通方法代码");
    }
}
