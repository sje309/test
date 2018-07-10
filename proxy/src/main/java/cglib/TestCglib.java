package cglib;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 17:10
 * @Description:
 */
public class TestCglib {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }
}
