package 静态代理;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 10:23
 * @Description:
 */
public class AdminPoly implements IManager {
    private Admin admin;

    public AdminPoly(Admin admin) {
        super();
        this.admin = admin;
    }

    @Override
    public void doSomething() {
        System.out.println("Log:admin操作开始");
        admin.doSomething();
        System.out.println("Log:admin操作结束");
    }
}
