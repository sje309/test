package spEL;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-17 15:45
 * @Description:
 */
public class Customer {
    private Item item;
    private String itemName;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
