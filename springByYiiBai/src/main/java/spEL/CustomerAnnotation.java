package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-17 16:23
 * @Description: 以注解的方式实现SpringEl表达式
 */
@Component(value = "customerAnnotation")
public class CustomerAnnotation {
    @Value(value = "#{itemBeanAnnotation}")
    private ItemAnnotation item;
    @Value(value = "#{itemBeanAnnotation.name}")
    private String itemName;

    public ItemAnnotation getItem() {
        return item;
    }

    public void setItem(ItemAnnotation item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
