import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Author: shuyizhi @Date: 2018-07-30 14:32 @Description: 通过NIO的方式操作文件
 * 参考：https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html
 * http://developer.51cto.com/art/201112/307172.htm
 */
public class IODemoByNIO {

    /**
     * InputStream读取文件(按行读取)
     *
     * @param filePath
     */
    public static void readFileByIO(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(filePath);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            int count = 0;
            while ((str = reader.readLine()) != null) {
                // 输出文件内容
                // System.out.println(str);
                count++;
            }
            System.out.println("总共输出: " + count + " 条");
        } catch (FileNotFoundException e) {
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
        }
    }

    /**
     * 按行读取文件内容,并返回输出的条数
     *
     * @param filePath
     * @throws FileNotFoundException
     */
    public static void readLinesFile(String filePath) throws FileNotFoundException {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("指定的文件: " + filePath + "不存在!");
        }
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        String content = null;
        int count = 0;
        try {
            inputStream = new FileInputStream(filePath);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            content = reader.readLine();
            if (content != null) {
                count++;
                System.out.println(content);
            }
            System.out.println("总共输出: " + count + " 条数据!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过FileChannel从指定的文件中读取数据(按行读取)
     *
     * @param filePath 文件路径
     */
    public static void readFileByChannel(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        try {
            List<String> lists = Files.readAllLines(Paths.get(filePath));
            int count = 0;
            for (String str : lists) {
                // 输出文件内容
                System.out.println(str);
                count++;
            }
            System.out.println("总共输出: " + count + " 条");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileByChannelReader(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        RandomAccessFile file = null;
        FileChannel channel = null;
        try {
            file = new RandomAccessFile(filePath, "rw");
            channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                System.out.print(Charset.forName("UTF-8").decode(buffer));
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != file) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != channel) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
