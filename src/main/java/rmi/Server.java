package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:34
 * @Description:
 */
public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            HelloService service = new HelloServiceImpl("service1");
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://localhost:1099/HelloService1", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully register a remote object.");
    }
}
