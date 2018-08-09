package tcpip;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-09 10:20 @Description: */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 指定监听的接口
        int port = 55533;
        ServerSocket serverSocket = new ServerSocket(port);
        // server将等待连接
        System.out.println("server将一直等待连接的到来");
        Socket socket = serverSocket.accept();
        // 建立连接，从socket中获取输入流，并建立缓冲区进行读写
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        inputStream.close();
        serverSocket.close();
        socket.close();
    }
}
