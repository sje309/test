import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Author: shuyizhi @Date: 2018-08-09 17:05 @Description:Mina服务端
 * 参考：https://blog.csdn.net/jy_he/article/details/52326190
 */
public class MinaTimeServer {
    public static final int PORT = 6488;

    public static void main(String[] args) throws IOException {
        // 创建服务端监控线程,使用Socket通讯方式作为服务的接入
        IoAcceptor acceptor = new NioSocketAcceptor();
        // IoSessionConfig表示会话的配置信息，主要包括：读缓冲区大小，会话数据吞吐量，计算吞吐量的时间间隔，指定会话段的空闲时间，写请求操作超时时间等
        acceptor.getSessionConfig().setReadBufferSize(1024 * 2);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        // 设置日志记录器
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置编码过滤器
        acceptor.getFilterChain()
                .addLast("code", new ProtocolCodecFilter(new TextLineCodecFactory()));
        // 设置业务逻辑处理器
        acceptor.setHandler(new TimeServerHandler());
        // 设置端口号
        acceptor.bind(new InetSocketAddress(PORT));
        // 启动线程监听器
        acceptor.bind();
    }
}
