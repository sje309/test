package thrift.helloWorld.TNonblockingServer;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.helloWorld.HelloWorldImpl;
import thrift.helloWorld.HelloWorldService;

/**
 * @Author: shuyizhi @Date: 2018-09-18 14:44 @Description: TNonblocking服务模型
 * 使用非阻塞IO，服务端和客户端需要指定TFramedTransport数据传输方式
 */
public class HelloServer {
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TNonblockingServer start ....");
            TProcessor tProcessor =
                    new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            TNonblockingServerSocket tNonblockingServerSocket =
                    new TNonblockingServerSocket(SERVER_PORT);
            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(tNonblockingServerSocket);
            tnbArgs.processor(tProcessor);
            tnbArgs.transportFactory(new TFastFramedTransport.Factory());
            tnbArgs.protocolFactory(new TCompactProtocol.Factory());

            TServer server = new TNonblockingServer(tnbArgs);
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
