package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:37
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        String url = "rmi://localhost:1099/";
        try {
            Context namingContext = new InitialContext();
            HelloService serv = (HelloService) namingContext.lookup(url + "HelloService1");
            String data = "This is RMI Client.";
            System.out.println(serv.serivce(data));
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
