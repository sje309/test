import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author: shuyizhi @Date: 2018-08-01 16:27 @Description: select服务端
 * 参考：https://blog.csdn.net/logicteamleader/article/details/69666274
 */
public class SelectServer {
    private static final int PORT = 1234;
    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(PORT));
            /** 非阻塞模式 */
            ssc.configureBlocking(false);
            /** 1、register() */
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.print("REGISTER CHANNEL,CHANNEL NUMBER IS: " + selector.keys().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
