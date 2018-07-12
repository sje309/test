package xml;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 14:04
 * @Description:
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("------------User核心业务:保存!!!-------------");
    }
}
