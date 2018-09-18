package thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/** @Author: shuyizhi @Date: 2018-09-18 10:49 @Description: */
public class HelloServiceServer {
    public static void main(String[] args) {
        try {
            System.out.println("服务端开启...");
            TProcessor tProcessor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
            // 简单的单线程服务模型
            TServerSocket serverSocket = new TServerSocket(9898);
            TServer.Args tArgs = new TServer.Args(serverSocket);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
