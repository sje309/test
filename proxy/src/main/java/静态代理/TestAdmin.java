package 静态代理;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 10:26
 * @Description: 测试Admin静态代理
 */
public class TestAdmin {
    public static void main(String[] args) {
        Admin admin = new Admin();
        IManager manager = new AdminPoly(admin);
        manager.doSomething();
    }
}
