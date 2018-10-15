package factoryMethod;

/** @Author: shuyizhi @Date: 2018-10-11 14:32 @Description: 具体工厂 */
public class FashionFactory implements IFactory {
    @Override
    public ICoat createCoat() {
        System.out.println("创建Fashion Coat!");
        return new FashionCoat();
    }
}
