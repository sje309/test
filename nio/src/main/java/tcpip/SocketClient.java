package tcpip;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/** @Author: shuyizhi @Date: 2018-08-09 10:49 @Description: */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        // 要建立的服务端IP和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立建立后获取输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 yiwangzhibujian";

        socket.getOutputStream().write(message.getBytes(Charset.forName("UTF-8")));
        outputStream.close();
        socket.close();
    }
}
