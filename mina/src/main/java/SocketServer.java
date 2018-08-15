import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** @Author: shuyizhi @Date: 2018-08-10 11:16 @Description: */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(55555);
        Socket socket = serverSocket.accept();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("服务端: 开源中国杭州论坛");
        ps.println("服务端: 杭州G20峰会");
        // 关闭输出流，表面输出已经结束
        socket.shutdownOutput();
        // socket.shutdownOutput();
        // 判断该socke是否关闭
        System.out.println("socket.isClosed(): " + socket.isClosed());
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
        socket.close();
    }
}
