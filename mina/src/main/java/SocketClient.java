import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-10 11:27 @Description: */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 55555);
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[2014];
        int flag = 0;
        while ((flag = is.read(buffer, 0, buffer.length)) != -1) {
            String str = new String(buffer, 0, flag);
            System.out.print(str);
        }
        OutputStream os = socket.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println("客户端: 欢迎参加开源中国论坛");
        printStream.println("客户端: 欢迎参加G20峰会");

        is.close();
        printStream.close();
        socket.close();
    }
}
