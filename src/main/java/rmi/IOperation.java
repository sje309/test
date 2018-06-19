package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 15:26
 * @Description:
 */
public interface IOperation extends Remote {
    int add(int a, int b) throws RemoteException;
}
