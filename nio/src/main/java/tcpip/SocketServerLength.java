package tcpip;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/** @Author: shuyizhi @Date: 2018-08-09 14:16 @Description: 通过指定的长度告诉对方已发送完命令 */
public class SocketServerLength {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(IpCommons.port);
        System.out.println("server将一直等待连接的到来");
        Socket socket = serverSocket.accept();
        // 连接连接后，从socket中获取输入流，并建立缓冲区进行读写
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        while (true) {
            // 首先读取两个字节表示的长度
            int first = inputStream.read();
            // 如果读取的值为-1,说明到了流的末尾，socket已经被关闭,此时不能再去读取
            if (first == -1) {
                break;
            }
            int second = inputStream.read();
            int length = (first << 8) + second;
            // 构造数组
            bytes = new byte[length];
            // 读取指定长度的消息
            inputStream.read(bytes);
            System.out.println(
                    "Get Message From Client: " + new String(bytes, Charset.forName("UTF-8")));

        }
        // 关闭
        IOUtils.closeStream(inputStream, null);
        IOUtils.closeSocket(socket);
        IOUtils.closeServerSocket(serverSocket);
    }
}
