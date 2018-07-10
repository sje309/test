package 动态代理;

import 静态代理.IUserDao;
import 静态代理.UseDao;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 16:37
 * @Description: 动态代理测试
 */
public class Test {
    public static void main(String[] args) {
        IUserDao target = new UseDao();
        System.out.println(target.getClass());

        //给目标对象，创建代理对象 内存中生成代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());   //内存对象 class com.sun.proxy.$Proxy0
        //执行代理对象的方法
        proxy.save();
    }
}
