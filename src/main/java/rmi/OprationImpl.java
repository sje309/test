package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 15:26
 * @Description:
 */
public class OprationImpl extends UnicastRemoteObject implements IOperation {
    public OprationImpl() throws RemoteException{
        super();
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
