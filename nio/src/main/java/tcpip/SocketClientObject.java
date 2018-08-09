package tcpip;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ResourceBundle;

/** @Author: shuyizhi @Date: 2018-08-09 11:33 @Description: */
public class SocketClientObject {
    public static String ipaddress;
    public static int port;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ipadress");
        ipaddress = resourceBundle.getString("ip");
        port = Integer.parseInt(resourceBundle.getString("port"));
    }

    public static void main(String[] args) throws Exception {
        // 与服务端建立连接
        Socket socket = new Socket(ipaddress, port);
        // 获取建立连接的输出流，并写入服务端，供服务端读取
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Person person = new Person();
        person.setAge(32);
        person.setAddress("安徽省合肥市高新区");
        person.setName("束义志");

        objectOutputStream.writeObject(person);

        // 通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person person1 = (Person) objectInputStream.readObject(); // 获取服务端的数据
        System.out.println("Get message from server: " + person1.toString());

        socket.close();
        outputStream.close();
        objectOutputStream.close();
    }
}
