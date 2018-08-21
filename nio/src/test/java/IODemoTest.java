import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/** @Author: shuyizhi @Date: 2018-07-30 10:03 @Description: */
public class IODemoTest {

    @Test
    public void createFile() {
        String filePath = "D:\\IOTest\\iotest.txt";
        FileModel model = IODemo.createFile(filePath);
        System.out.println(model.toString());
    }

    @Test
    public void countFileLength() {
        String filePath = "D:\\solr.json";

        System.out.println("==============InputStream====================");
        long start = System.currentTimeMillis();
        IODemo.countFileLength(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("==============BufferedInputStream====================");
        start = System.currentTimeMillis();
        IODemo.countFileLengthByBuffer(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("==============DataInputStream====================");
        start = System.currentTimeMillis();
        IODemo.countFileLengthByDataInputStream(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    public void testCopyFile() {
        String sourceFile = "D:\\solr.json";
        String destFile = "D:\\IoTest\\solr1111.json";

        long start = System.currentTimeMillis();
        IODemo.copyFileByStream(sourceFile, destFile);
        System.out.println("==============InputStream====================");
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        destFile = "D:\\IoTest\\Bufferedsolr.json";
        start = System.currentTimeMillis();
        IODemo.copyFileByBufferedStream(sourceFile, destFile);
        System.out.println("==============BufferedStream====================");
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        destFile = "D:\\IoTest\\DataStreamsolr.json";
        start = System.currentTimeMillis();
        IODemo.copyFileByDataStream(sourceFile, destFile);
        System.out.println("==============DataStream====================");
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        destFile = "D:\\IoTest\\Channelsolr.json";
        start = System.currentTimeMillis();
        IODemo.copyFileByFileChannel(sourceFile, destFile);
        System.out.println("==============FileChannel====================");
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    public void testReadFile() {
        String filePath = "D:\\shakespeare.json";

        long start = System.currentTimeMillis();
        // IODemo.readFileByFileReader(filePath);
        // System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println(
                "=============================BufferedReader===============================");
        IODemo.readFileByBuffered(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("=============================CommonsIO===============================");
        IODemo.readFileByCommonsIO(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("=============================NIO===============================");
        IODemo.readFileByNIO(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    public void testWriteFile() {
        String filePath = "D:\\testwriter\\testFileWriter.txt";
        int count = 100000;
        long start = System.currentTimeMillis();
        String content =
                "{\"account_number\":867,\"balance\":45453,\"firstname\":\"Blanca\",\"lastname\":\"Ellison\",\"age\":23,\"gender\":\"F\",\"address\":\"593 McKibben Street\",\"employer\":\"Koogle\",\"email\":\"blancaellison@koogle.com\",\"city\":\"Frystown\""
                        + ",\"state\":\"WY\"}";
        content += "\r\n";

        for (int i = 0; i < count; i++) {
            IODemo.writeFileByFileWriter(filePath, content);
        }
        System.out.println(StringUtils.center("FileWriter", 30, "="));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        filePath = "D:\\testwriter\\bufferedWriter.txt";
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            IODemo.writeFileByBufferedWriter(filePath, content);
        }
        System.out.println(StringUtils.center("BufferedWriter", 30, "="));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        filePath = "D:\\testwriter\\nioWriter.txt";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(content);
        }
        start = System.currentTimeMillis();
        IODemo.writerFileByNIOFiles(filePath, list);
        System.out.println(StringUtils.center("nio", 30, "="));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        filePath = "D:\\testwriter\\commonsioWriter.txt";
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            IODemo.writerFileByCommonsIO(filePath, content);
        }
        System.out.println(StringUtils.center("ApacheCommonsIO", 30, "="));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        filePath = "D:\\testwriter\\writeStringToFile.txt";
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            IODemo.writerFileByCommonsIOWriteStringToFile(filePath, content);
        }
        System.out.println(StringUtils.center("wirteStringToFile", 30, "="));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    public void testScan() {
        try {
            scanPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试扫描端口
     *
     * @throws IOException
     */
    public static void scanPort() throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        System.out.println("80");
        socket.close();

        socket = new Socket("127.0.0.1", 8161);
        System.out.println("8161");
        socket.close();

        socket = new Socket("127.0.0.1", 3306);
        System.out.println("3306");
        socket.close();
    }
}
