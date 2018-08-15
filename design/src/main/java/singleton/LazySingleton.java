package singleton;

/** @Author: shuyizhi @Date: 2018-08-14 9:20 @Description: */
public class LazySingleton {
    private LazySingleton() {
        System.out.println("生成LazySingleton实例一次!");
    }

    private static LazySingleton lazyInstance = null;

    public static LazySingleton getLazyInstance() {
        if (null == lazyInstance) {
            lazyInstance = new LazySingleton();
        }
        return lazyInstance;
    }
}
