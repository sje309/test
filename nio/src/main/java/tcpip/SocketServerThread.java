package tcpip;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @Author: shuyizhi @Date: 2018-08-09 15:03 @Description: 多线程环境下ServerSocket */
public class SocketServerThread {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(IpCommons.port);
        System.out.println("server将一直等待连接的到来");
        // 如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        while (true) {
            Socket socket = serverSocket.accept();
            Runnable runnable =
                    () -> {
                        try {
                            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                            InputStream inputStream = socket.getInputStream();
                            byte[] bytes = new byte[1024];
                            int len;
                            StringBuilder sb = new StringBuilder();
                            while ((len = inputStream.read(bytes)) != -1) {
                                // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                                sb.append(new String(bytes, 0, len, "UTF-8"));
                            }
                            System.out.println("get message from client: " + sb);
                            inputStream.close();
                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    };
            threadPool.submit(runnable);
        }
    }
}
