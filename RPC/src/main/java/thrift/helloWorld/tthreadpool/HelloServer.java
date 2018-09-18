package thrift.helloWorld.tthreadpool;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.helloWorld.HelloWorldImpl;
import thrift.helloWorld.HelloWorldService;

/** @Author: shuyizhi @Date: 2018-09-18 14:35 @Description: */
public class HelloServer {
    private static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TThreadPoolServer start...");
            TProcessor tProcessor =
                    new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
            ttpsArgs.processor(tProcessor);
            ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());
            /** 线程池服务模式，使用标准的阻塞IO，预先创建一组线程处理请求 */
            TServer server = new TThreadPoolServer(ttpsArgs);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HelloServer server = new HelloServer();
        server.startServer();
    }
}
