package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 15:28
 * @Description:
 */
public class OprationServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        IOperation iOperation = new OprationImpl();
        Naming.bind("rmi://127.0.0.1/Operation", iOperation);
        System.out.println("service runing....");
    }
}
