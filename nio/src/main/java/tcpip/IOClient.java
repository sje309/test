package tcpip;

import java.io.*;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-08 13:46 @Description: */
public class IOClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            // 1、创建客户端Socket,指定服务器和端口
            socket = new Socket("localhost", 10086);
            // 2、获取输出流,向服务器端发送信息
            outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名: administrator;密码: 123");
            printWriter.flush();
            socket.shutdownInput();
            // 3、获取输入流，并读取服务器端的响应信息
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是客户端，服务器说: " + info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭资源
            IOUtils.closeSocket(socket);
            IOUtils.closeStream(inputStream, outputStream);
            IOUtils.closeReader(bufferedReader);
        }
    }
}
