package singleton;

/** @Author: shuyizhi @Date: 2018-08-14 10:51 @Description: */
public class SafeLazySingleton {
    private SafeLazySingleton() {
        System.out.println("生成SafeLazySingleton实例一次!");
    }

    private static SafeLazySingleton instance = null;

    public static synchronized SafeLazySingleton getInstance() {
        if (null == instance) {
            instance = new SafeLazySingleton();
        }
        return instance;
    }

    public static SafeLazySingleton getInstance1() {
        if (null == instance) {
            synchronized (SafeLazySingleton.class) {
                if (null == instance) {
                    instance = new SafeLazySingleton();
                }
            }
        }
        return instance;
    }
}
