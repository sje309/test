package thrift.helloWorld.thshaServer;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.helloWorld.HelloWorldImpl;
import thrift.helloWorld.HelloWorldService;

/**
 * @Author: shuyizhi
 * @Date: 2018-09-18 22:44
 * @Description: THsHaServer服务模式：半同步半异步服务模式,TFramedTransport数据传输方式
 */
public class HelloServer {
    public static final int SERVER_IP = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld THsHaServer start ....");
            TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(SERVER_IP);
            THsHaServer.Args thhsArgs = new THsHaServer.Args(tnbSocketTransport);
            thhsArgs.processor(tProcessor);
            thhsArgs.transportFactory(new TFramedTransport.Factory());
            thhsArgs.protocolFactory(new TBinaryProtocol.Factory());

            /**半同步半异步的服务模式*/
            TServer server = new THsHaServer(thhsArgs);
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
