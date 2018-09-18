package thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/** @Author: shuyizhi @Date: 2018-09-18 10:57 @Description: */
public class HelloServiceClient {
    public static void main(String[] args) {
        System.out.println("客户端启动...");
        TTransport tTransport = null;
        try {
            tTransport = new TSocket("localhost", 9898, 3000);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(tTransport);
            Hello.Client client = new Hello.Client(protocol);
            tTransport.open();
            String result = client.helloString("哈哈");
            System.out.println(result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != tTransport) {
                tTransport.close();
            }
        }
    }
}
