package simpleFactory;

/** @Author: shuyizhi @Date: 2018-10-10 15:38 @Description: */
public class SimpleFactory {
    public ICoat createCoat(String styleName) {
        switch (styleName.trim().toLowerCase()) {
            case "business":
                return new BusinessCoat();
            case "fashion":
                return new FashionCoat();
            default:
                throw new IllegalArgumentException("参数错误");
        }
    }
}
