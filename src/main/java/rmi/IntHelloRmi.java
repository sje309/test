package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 9:26
 * @Description:
 */
public interface IntHelloRmi extends Remote {
    String helloRmi() throws RemoteException;
    String sayHello(String name) throws RemoteException;
}
