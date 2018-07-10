package 静态代理;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 14:05
 * @Description: 代理对象，静态代理
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;        //接受保存目标对象

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务.......");
        target.save();      //执行目标对象的方法
        System.out.println("提交事务......");
    }
}
