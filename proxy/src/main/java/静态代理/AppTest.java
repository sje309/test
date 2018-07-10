package 静态代理;


/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 14:09
 * @Description: 静态代理测试
 * 参考：https://www.cnblogs.com/cenyu/p/6289209.html
 */
public class AppTest {
    public static void main(String[] args) {
        //目标对象
        UseDao target = new UseDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();       //执行代理对象的方法

    }
}
