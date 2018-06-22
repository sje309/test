package thread;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-21 11:11
 * @Description: 单例模式
 * 参考:https://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton singleton = null;

    public static Singleton getInstance() {
        if (null == singleton) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
