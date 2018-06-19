package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 15:30
 * @Description:
 */
public class OperationClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IOperation iOperation = (IOperation) Naming.lookup("rmi://127.0.0.1/Operation");
        System.out.println("1+1= " + iOperation.add(1, 1));
    }
}
