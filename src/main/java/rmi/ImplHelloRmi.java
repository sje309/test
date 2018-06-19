package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 9:27
 * @Description:
 */
public class ImplHelloRmi extends UnicastRemoteObject implements IntHelloRmi {
    private static final long serialVersionUID = 4171109735554301389L;

    public ImplHelloRmi() throws RemoteException {
        super();
    }

    @Override
    public String helloRmi() throws RemoteException {
        return "Hello Rmi";
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello " + name + "!";
    }
}
