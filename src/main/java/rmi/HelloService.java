package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:28
 * @Description:
 */
public interface HelloService extends Remote {
    //Remote method should throw RemoteException
    String serivce(String data) throws RemoteException;
}
