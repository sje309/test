package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 16:48
 * @Description:
 */
public class ServerTest {
    private int port = 1122;
    private ServerSocket serverSocket;

    public ServerTest() throws Exception {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动!");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " +
                        socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != socket) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ServerTest test = new ServerTest();
        Thread.sleep(30 * 1000);
        test.service();
    }
}
