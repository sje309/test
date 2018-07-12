package xml;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 14:02
 * @Description:
 */
@Component
@Scope(value = "prototype")
public class OrderDao {
    public void save() {
        System.out.println("------------Order核心业务:保存!!!-------------");
    }
}
