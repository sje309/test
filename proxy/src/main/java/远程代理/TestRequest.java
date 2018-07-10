package 远程代理;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 11:17
 * @Description:
 */
public class TestRequest {
    public static void main(String[] args) {
        try {
            MyRemote myRemote = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteCalculator");
            MyRequest myRequest = new MyRequest(myRemote);
            myRequest.print();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
