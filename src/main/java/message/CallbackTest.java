package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 14:13
 * @Description: 回调模式
 * 参考：https://blog.csdn.net/wanglha/article/details/51383245
 */
public class CallbackTest {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("Server,Hello ~");
    }
}
