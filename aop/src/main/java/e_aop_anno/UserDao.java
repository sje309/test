package e_aop_anno;

import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 16:49
 * @Description: 目标对象
 */
@Component      //加入容器
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("------------UserDao核心业务:保存!!!-------------");
    }
}
