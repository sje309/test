package simpleFactory;

import java.util.Scanner;

/** @Author: shuyizhi @Date: 2018-10-10 15:44 @Description: */
public class Client {
    public static void main(String[] args) {
        ICoat coat;
        System.out.println("请输入style:");
        Scanner scanner = new Scanner(System.in);
        String style = scanner.next().toLowerCase();
        SimpleFactory factory = new SimpleFactory();

        switch (style) {
            case "business":
                System.out.println("business");
                factory.createCoat(style);

                coat = new BusinessCoat();
                coat.getYourCoat();
                break;
            case "fashion":
                System.out.println("fashion");
                factory.createCoat(style);

                coat = new FashionCoat();
                coat.getYourCoat();
                break;
            default:
                throw new IllegalArgumentException("参数错误");
        }
    }
}
