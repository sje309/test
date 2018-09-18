package thrift.helloWorld;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/** @Author: shuyizhi @Date: 2018-09-18 13:52 @Description: */
public class HelloServer {
    private static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TSimpleServer start......");
            TProcessor tProcessor =
                    new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
            /** 单线程服务模式，用于测试 */
            TServerSocket serverSocket = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverSocket);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());

            /** 单线程模式 */
            TServer server = new TSimpleServer(tArgs);
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
