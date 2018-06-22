import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-22 10:54
 * @Description: http://www.cnblogs.com/xiaoxi/p/6534926.html
 */
public class IntBufferTest {
    public static void main(String[] args) {
        //IntBuffer buffer = IntBuffer.allocate(8);   //分配新的int缓冲区,参数为缓冲区容量
        //for (int i = 0; i < buffer.capacity(); i++) {
        //    int j = 2 * (i + 1);
        //    buffer.put(j);  //将给定整数写入此缓冲区的当前位置，当前位置递增
        //}
        //buffer.flip();      //重设缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        //while (buffer.hasRemaining()) {
        //    int j = buffer.get();
        //    System.out.println(j + " ");
        //}


        try {
            readFileByChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void outPut(String step, Buffer buffer) {
        System.out.println(step + ":");
        System.out.print("capacity: " + buffer.capacity() + ",");
        System.out.print("position: " + buffer.position() + ",");
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }

    public static void readFileByChannel() throws IOException {
        File file = new File("D:\\db_studentTest.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
        fileChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        buffer.clear();
        fileInputStream.close();
    }
}
