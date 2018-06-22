package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-21 13:43
 * @Description: NIO
 * 参考：https://blog.csdn.net/qq_18860653/article/details/53406723
 */
public class TestRandomAccessFile {
    public static void main(String[] args) throws Exception {
        String inFile = "D:\\tekuan1.json";
        String outFile = "D:\\tk.json";

        FileInputStream fileInputStream = new FileInputStream(inFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);

        FileChannel cin = fileInputStream.getChannel();
        FileChannel cout = fileOutputStream.getChannel();

        //定义缓冲区,并指定大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //清空缓冲区
            buffer.clear();
            int r = cin.read(buffer);
            if (r == -1) {
                break;
            }
            buffer.flip();          //将buffer指针指向头部
            cout.write(buffer);     //把缓冲区数据写入通道

        }
    }
}
