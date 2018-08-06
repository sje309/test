import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

/** @Author: shuyizhi @Date: 2018-08-03 15:49 @Description:测试有关Java大数运算 */
public class TestBigNumber {
    public static void main(String[] args) {
        /*  BigInteger b1 = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("789456123");

        System.out.println("b1+b2= " + b1.add(b2));
        System.out.println("b1-b2: " + b1.subtract(b2));
        System.out.println("b1*b2= " + b1.multiply(b2));
        System.out.println("b1/b2: " + b1.divide(b2));*/

        Proxy target = new Proxy();
        try {
            /** 获取无参的方法 */
            Method method = Proxy.class.getDeclaredMethod("run");
            /** 调用方法 */
            method.invoke(target);

            /** 获取有参数的，并指定参数类型 */
            Method method1 = Proxy.class.getDeclaredMethod("bigNumber", String.class, String.class);
            method1.invoke(target, "123456789", "789456123");

            Method method2 = Proxy.class.getDeclaredMethod("bigNumber", String.class, String.class);
            method2.invoke(target, "123456789", "789456123");

            /** 获取字段 */
            Field field = Proxy.class.getDeclaredField("a");
            field.setAccessible(true);
            field.set(target, 100);
            System.out.println(target.getA());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    static class Proxy {
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void run() {
            System.out.println("run");
        }

        public void bigNumber(String s1, String s2) {
            BigInteger b1 = new BigInteger(s1);
            BigInteger b2 = new BigInteger(s2);

            System.out.println("b1+b2= " + b1.add(b2));
            System.out.println("b1-b2: " + b1.subtract(b2));
            System.out.println("b1*b2: " + b1.multiply(b2));
            System.out.println("b1/b2: " + b1.divide(b2));
        }
    }
}
