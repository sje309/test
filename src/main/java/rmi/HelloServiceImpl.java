package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:30
 * @Description:
 */
public class HelloServiceImpl extends UnicastRemoteObject
        implements HelloService {
    private static final long serialVersionUID = -9207197983765229242L;
    private String name;

    public HelloServiceImpl(String name) throws RemoteException {
        super();
        this.name = name;
    }

    public String serivce(String data) throws RemoteException {
        return name + "  " + data;
    }
}
