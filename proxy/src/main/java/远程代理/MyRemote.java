package 远程代理;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 11:07
 * @Description:
 */
public interface MyRemote extends Remote {
    int add(int a, int b) throws RemoteException;

    int sub(int a, int b) throws RemoteException;
}
