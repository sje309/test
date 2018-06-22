import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-22 11:56
 * @Description:
 */
public class TestFileChannel {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\tk.json");

        //创建filechannel
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        //读取数据
        int bytesRead = fileChannel.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();
            System.out.println(Charset.forName("utf-8").decode(buffer));
            buffer.clear();
        }


        //重置
        //buffer.flip();

        //while (buffer.remaining() > 0) {
        //    byte b = buffer.get();
        //    System.out.println((char) b);
        //}

        fileInputStream.close();
    }
}
