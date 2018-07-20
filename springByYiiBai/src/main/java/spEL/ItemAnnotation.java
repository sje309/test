package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-17 16:21
 * @Description: 通过注解的方式实现SpringEL
 */
@Component(value = "itemBeanAnnotation")
public class ItemAnnotation {
    @Value(value = "束义志")
    private String name;
    @Value(value = "30")
    private int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ItemAnnotation{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
