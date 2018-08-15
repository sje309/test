import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** @Author: shuyizhi @Date: 2018-08-10 15:06 @Description:基于UDP客户端 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5555);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String str = new String(buffer, 0, packet.getLength());
        System.out.println(str);

        // 接收到数据包之后，客户端返回响应回去
        String str2 = "welcome";
        DatagramPacket packet2 =
                new DatagramPacket(
                        str2.getBytes(), str2.length(), packet.getAddress(), packet.getPort());
        ds.send(packet2);
        ds.close();
    }
}
