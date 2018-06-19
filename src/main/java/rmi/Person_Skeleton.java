package rmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 16:12
 * @Description:
 */
public class Person_Skeleton extends Thread {
    private PersonServer myServer;

    public Person_Skeleton(PersonServer server) {
        this.myServer = server;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket socket = serverSocket.accept();
            while (null != socket) {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String method = (String) inputStream.readObject();
                if (method.equals("age")) {
                    int age = myServer.getAge();
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeInt(age);     //return result to stub
                    outputStream.flush();
                }
                if (method.equals("name")) {
                    String name = myServer.getName();
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(name);     //return result to stub
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
