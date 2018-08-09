package tcpip;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ResourceBundle;

/** @Author: shuyizhi @Date: 2018-08-09 11:20 @Description: */
public class SocketServerObject {
    public static String ipaddress;
    public static int port;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ipadress");
        ipaddress = resourceBundle.getString("ip");
        port = Integer.parseInt(resourceBundle.getString("port"));
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server将一直等待......");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person person = (Person) objectInputStream.readObject();
        System.out.println("获取客户端的数据为: " + person.toString());

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(person);

        // 关闭资源
        IOUtils.closeStream(inputStream, outputStream);
        IOUtils.closeStream(objectInputStream, objectOutputStream);
        IOUtils.closeServerSocket(serverSocket);
        IOUtils.closeSocket(socket);
    }
}
