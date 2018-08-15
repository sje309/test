import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: shuyizhi @Date: 2018-08-13 14:08 @Description: socket传输实体
 * 参考：https://www.cnblogs.com/boshen-hzb/p/5891498.html
 */
public class SimpleServer {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            /** 记录客户端的数量 */
            int count = 0;
            System.out.println("服务器启动,等待客户端的连接.....");
            while (true) {
                socket = serverSocket.accept();
                ++count;
                Thread serverHandleThread = new Thread(new ServerHanldeThread(socket));
                serverHandleThread.setPriority(4);
                serverHandleThread.start();
                System.out.println("上线的客户端有 " + count + " 个!");
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP地址是: " + inetAddress.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
