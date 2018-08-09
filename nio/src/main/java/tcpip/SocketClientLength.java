package tcpip;

import java.io.OutputStream;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-09 14:43 @Description: */
public class SocketClientLength {
    public static void main(String[] args) throws Exception {
        // 与服务端建立连接
        Socket socket = new Socket(IpCommons.ipaddress, IpCommons.port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 yiwangzhibujian";
        // 计算得知消息的长度
        byte[] sendBytes = message.getBytes("UTF-8");
        // 优先发送消息的长度
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        // 发送具体消息message
        outputStream.write(sendBytes);
        outputStream.flush();

        // 重复发送、第二条
        message = "第二条消息";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();

        // 重复发送、第三条
        message = "the third message!";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();

        // 关闭资源
        IOUtils.closeStream(null, outputStream);
        IOUtils.closeSocket(socket);
    }
}
