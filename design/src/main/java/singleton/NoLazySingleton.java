package singleton;

/** @Author: shuyizhi @Date: 2018-08-14 9:31 @Description: */
public class NoLazySingleton {
    private static NoLazySingleton instance = new NoLazySingleton();

    /** 私有化构造函数，防止在该类外部通过new的形式创建实例 */
    private NoLazySingleton() {
        System.out.println("创建NoLazySingleton实例一次!");
    }

    /**
     * 公有的访问单例实例的方法
     *
     * @return
     */
    public static NoLazySingleton getInstance() {
        return instance;
    }
}
