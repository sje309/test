package thrift.helloWorld.thshaServer;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.helloWorld.HelloWorldService;
import thrift.helloWorld.User;

/**
 * @Author: shuyizhi
 * @Date: 2018-09-18 22:56
 * @Description:
 */
public class HelloClient {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    public void startClient(User u) {
        TTransport tTransport = null;
        try {
            tTransport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
            TProtocol protocol = new TBinaryProtocol(tTransport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            tTransport.open();
            String result = client.sayHello(u);
            System.out.println("Thrify client result=: " + result);
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
