import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: shuyizhi @Date: 2018-08-10 14:13 @Description: 基于UDP协议的网络编程
 * 参考：http://www.cnblogs.com/dongguacai/p/5747603.html
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String str = "hello world";
        // 构造用于发送的数据包，指定主机和端口号
        DatagramPacket packet =
                new DatagramPacket(
                        str.getBytes(), str.length(), InetAddress.getByName("localhost"), 5555);
        ds.send(packet);

        // 读取从客户端发送过来的响应
        byte[] buffer = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet2);
        String str2 = new String(buffer, 0, packet2.getLength());
        System.out.println(str2);
        ds.close();
    }
}
