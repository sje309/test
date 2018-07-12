package proxyfactory;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 17:12
 * @Description: 模拟具体业务
 */
public class UserServiceImpl implements UserService {
    @Override
    public void updateUser() {
        System.out.println("$$$$$$$执行业务逻辑$$$$$");
    }
}
