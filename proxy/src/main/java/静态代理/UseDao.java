package 静态代理;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 14:04
 * @Description: 接口实现，目标对象
 */
public class UseDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("--------已保存数据--------");
    }
}
