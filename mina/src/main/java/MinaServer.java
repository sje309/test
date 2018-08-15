import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Author: shuyizhi @Date: 2018-08-09 16:16 @Description:简单MinaServer
 * 参考：https://www.cnblogs.com/zhujiabin/p/5314283.html
 */
public class MinaServer {
    /** 定义监听端口 */
    private static final int PORT = 22222;

    public static void main(String[] args) throws IOException {
        // 创建一个非阻塞的Server端socket,用NIO
        IoAcceptor acceptor = new NioSocketAcceptor();
        // 创建接受数据的过滤器
        DefaultIoFilterChainBuilder chainBuilder = acceptor.getFilterChain();
        // 设置过滤器一行一行读取数据
        chainBuilder.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        // 指定业务逻辑处理器
        acceptor.setHandler(new Handler());
        // 设置端口号
        acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
        // 启动监听
        acceptor.bind();
        System.out.println("Mina Server is Listen on: " + PORT);
    }
}
