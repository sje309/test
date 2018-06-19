package rmi;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 15:55
 * @Description:
 */
public class Person_Stub implements IPerson {
    private Socket socket;

    public Person_Stub() throws Throwable {
        //connect to skeleton
        socket = new Socket("127.0.0.1", 9000);
    }

    @Override
    public int getAge() throws Throwable {
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return inStream.readInt();

    }

    @Override
    public String getName() throws Throwable {
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return (String) inStream.readObject();
    }
}
