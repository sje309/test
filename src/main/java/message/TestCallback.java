package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 11:07
 * @Description: 回调测试
 * 参考：https://blog.csdn.net/lemon_tree12138/article/details/51231841
 */
public class TestCallback {
    public static void main(String[] args) {
        Manager manager = new Manager(new Programer());
        manager.entrust();
    }
}
