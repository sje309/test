import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/** @Author: shuyizhi @Date: 2018-08-13 14:46 @Description: */
public class SimpleClient {
    public static void main(String[] args) {
        try {
            // 创建客户端Socket，指定服务器的IP和端口
            Socket socket = new Socket("127.0.0.1", 9999);
            // 获取该socket的输出流，用来向服务器发送信息
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(new UserModel(100, "shuyizhi", "123456"));
            socket.shutdownOutput();

            String info = null;
            // 输入流,获取服务器的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((info = br.readLine()) != null) {
                System.out.println("服务器端的信息: " + info);
            }
            socket.shutdownInput();
            is.close();
            br.close();
            oos.close();
            os.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
