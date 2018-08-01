import java.io.*;
import java.nio.channels.Channel;

/**
 * @Author: shuyizhi @Date: 2018-07-30 16:05 @Description: 关闭相关Stream和Channel
 * 参考：http://xurichusheng.iteye.com/blog/2266842
 */
public class IOUtils {
    /**
     * 关闭流对象
     *
     * @param inputStream 输入流
     * @param outputStream 输出流
     */
    public static void closeStream(InputStream inputStream, OutputStream outputStream) {
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != outputStream) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭 reader
     *
     * @param reader reader对象
     */
    public static void closeReader(Reader reader) {
        if (null != reader) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭writer
     *
     * @param writer writer对象
     */
    public static void closeWriter(Writer writer) {
        if (null != writer) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Channel通道
     *
     * @param channel channel对象
     */
    public static void closeChannel(Channel channel) {
        if (null != channel) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
