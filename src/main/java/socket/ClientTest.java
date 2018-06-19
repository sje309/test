package socket;

import java.net.Socket;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 17:00
 * @Description:
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        final int length = 10;
        String host = "localhost";
        int port = 1122;
        Socket[] sockets = new Socket[length];
        for (int i = 0; i < length; i++) {
            sockets[i] = new Socket(host, port);
            System.out.println("第" + (i + 1) + "次连接成功!");
        }
        Thread.sleep(3 * 1000);
        for (int i = 0; i < length; i++) {
            sockets[i].close();
        }
    }
}
