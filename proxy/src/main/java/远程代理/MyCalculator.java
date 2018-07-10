package 远程代理;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 11:05
 * @Description:
 */
public class MyCalculator extends UnicastRemoteObject implements MyRemote {

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    public MyCalculator() throws RemoteException {

    }
}
