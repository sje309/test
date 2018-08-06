/**
 * @Author: shuyizhi @Date: 2018-08-06 15:33 @Description: 测试有关static
 * 参考：https://blog.csdn.net/yabay2208/article/details/71171207
 */
public class StaticTest {
    // private int allNum = changeNum *2;
    private int changeNum = 0;
    public static int X; // X放在后面会提醒X非法
    public static int Y = X * 2;

    StaticTest(int changeNum) {
        this.changeNum = changeNum;
    }

    int getChangeNum() {
        return changeNum;
    }

    void setChangeNum(int changeNum) {
        this.changeNum = changeNum;
    }

    {
        X = 10; // 非static模块可以访问static变量
        changeNum = 100;
    }

    {
        changeNum = 99;
    }

    static {
        Y = 1;
        System.out.println("YYY");
    }

    static {
        X = 30;
        // changeNum = 100;static模块不可以访问非static变量
    }

    int getLength(String s) {
        return s.length() * 2;
    }

    public static void main(String[] args) {
        // System.out.println(X);
        // System.out.println(Y);
        StaticTest staticTest = new StaticTest(1);
        System.out.println(StaticTest.Y);
        System.out.println(X);
    }
}
