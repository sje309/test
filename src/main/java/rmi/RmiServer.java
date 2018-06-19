package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 9:30
 * @Description:
 */
public class RmiServer {
    private IntHelloRmi intHelloRmi;

    public void server() throws RemoteException, AlreadyBoundException, MalformedURLException {
        intHelloRmi = new ImplHelloRmi();
        //远程对象注册表实例
        LocateRegistry.createRegistry(9999);
        //把远程对象注册到RMI注册服务器上
        Naming.bind("rmi://localhost:9999/HelloRmi", intHelloRmi);
        System.out.println("server:对象绑定成功");
    }
    public static void main(String[] args){
        RmiServer server=new RmiServer();
        try {
            server.server();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
