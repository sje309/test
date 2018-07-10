package 静态代理;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 9:30
 * @Description: 真实主题类
 */
public class Admin implements IManager {
    @Override
    public void doSomething() {
        System.out.println("Admin do something.");
    }
}
