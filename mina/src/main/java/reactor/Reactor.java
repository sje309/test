package reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: shuyizhi @Date: 2018-08-10 16:36 @Description:
 * 参考：http://bijian1013.iteye.com/blog/2277792
 */
public class Reactor implements Runnable {
    private Selector selector = null;
    private ServerSocketChannel serverSocket = null;
    private static final Logger logger = LoggerFactory.getLogger(Reactor.class);

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), port);
        serverSocket.socket().bind(address);

        serverSocket.configureBlocking(false);
        // 向selector注册该channel
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        logger.info("-->Start serverSocket.register!");
        // 利用sk的attache功能绑定Acceptor，如果有事件，触发Acceptor
        // sk.attach(new Acceptor());

    }

    @Override
    public void run() {}

    class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                logger.info("-->ready for accept!");
                SocketChannel channel = serverSocket.accept();
                if (null != channel) {
                    // 调用handler来处理channel
                    // new SocketReadHandler(selector, c);
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.info("accept stop! " + e);
            }
        }
    }
}
