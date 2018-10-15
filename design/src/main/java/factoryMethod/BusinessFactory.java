package factoryMethod;

/** @Author: shuyizhi @Date: 2018-10-11 14:33 @Description: */
public class BusinessFactory implements IFactory {
    @Override
    public ICoat createCoat() {
        System.out.println("创建Business Coat!");
        return new BusinessCoat();
    }
}
