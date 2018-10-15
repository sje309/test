package factoryMethod;

/** @Author: shuyizhi @Date: 2018-10-11 14:29 @Description: 具体产品类 */
public class FashionCoat implements ICoat {
    @Override
    public void showCoat() {
        System.out.println("Fashion Coat!");
    }
}
