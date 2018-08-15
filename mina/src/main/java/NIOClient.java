import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: shuyizhi @Date: 2018-08-13 9:36 @Description: 使用FileChannel的零拷贝将本地文件内容传输到网络
 * 参考：http://www.jasongj.com/java/nio_reactor/
 */
public class NIOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(12345);
        socketChannel.connect(address);

        RandomAccessFile file =
                new RandomAccessFile(
                        NIOClient.class.getClassLoader().getResource("test.txt").getFile(), "rw");
        FileChannel channel = file.getChannel();
        channel.transferTo(0, channel.size(), socketChannel);
        channel.close();
        file.close();
        socketChannel.close();
    }
}
