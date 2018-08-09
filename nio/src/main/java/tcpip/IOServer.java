package tcpip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-08-08 13:46 @Description: */
public class IOServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(10086);
            socket = serverSocket.accept();
            // 获取输入流，并读取客户端信息
            inputStream = socket.getInputStream();
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器，客户端说: " + info);
            }
            socket.shutdownInput();
            // 获取输出流，响应客户端的请求
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("北京欢迎你");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /* InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL("http://www.baidu.com");
            inputStream = url.openStream();
            // reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();
            if (null != data) {
                System.out.println(data);
                data = bufferedReader.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        /* try {
            URL baidu = new URL("http://www.baidu.com");
            URL url = new URL(baidu, "/index.html?username=tom#test");
            System.out.println("protocol: " + url.getProtocol());
            System.out.println("host: " + url.getHost());
            System.out.println("port: " + url.getPort());
            System.out.println("path: " + url.getPath());
            System.out.println("ref: " + url.getRef());
            System.out.println("query: " + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

        /* ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
