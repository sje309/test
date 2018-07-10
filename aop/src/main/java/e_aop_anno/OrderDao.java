package e_aop_anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 16:53
 * @Description:
 */
@Component  //加入容器
@Scope(value = "prototype")
public class OrderDao {
    public void save() {
        System.out.println("------------核心业务:保存!!!-------------");
    }
}
