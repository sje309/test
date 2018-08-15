import java.io.*;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-13 14:10 @Description: */
public class ServerHanldeThread implements Runnable {
    Socket socket = null;

    public ServerHanldeThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        try {
            is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            System.out.println("客户端发送的对象: " + (UserModel) ois.readObject());
            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.println("欢迎登录!");
            pw.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != pw) {
                pw.close();
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
