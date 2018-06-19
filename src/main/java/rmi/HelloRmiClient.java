package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 9:35
 * @Description:
 */
public class HelloRmiClient {
    private IntHelloRmi helloRmi;

    public void client() throws RemoteException, NotBoundException, MalformedURLException {
        helloRmi = (IntHelloRmi) Naming.lookup("rmi://localhost:9999/HelloRmi");
        System.out.println("client:");
        System.out.println(helloRmi.helloRmi());
        System.out.println(helloRmi.sayHello("rmi"));
    }

    public static void main(String[] args) {
        HelloRmiClient client = new HelloRmiClient();
        try {
            client.client();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
