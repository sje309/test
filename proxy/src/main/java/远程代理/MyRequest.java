package 远程代理;

import java.rmi.RemoteException;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 11:13
 * @Description:
 */
public class MyRequest {
    MyRemote myRemote = null;

    public MyRequest(MyRemote myRemote) {
        this.myRemote = myRemote;
    }

    public void print() {
        int result;
        try {
            result = myRemote.add(123, 123);
            System.out.println(result);
            result = myRemote.sub(123, 123);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
