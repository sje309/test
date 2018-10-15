package factoryMethod;

/** @Author: shuyizhi @Date: 2018-10-11 14:29 @Description: 具体产品类 */
public class BusinessCoat implements ICoat {
    @Override
    public void showCoat() {
        System.out.println("Business Coat!");
    }
}
