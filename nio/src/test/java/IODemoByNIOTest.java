import org.junit.Test;

/** @Author: shuyizhi @Date: 2018-07-30 14:48 @Description: */
public class IODemoByNIOTest {

    @Test
    public void readFileByChannel() {
        // String filePath = "D:\\solr.json";
        String filePath = "D:\\fileUtils.txt";
        long start = System.currentTimeMillis();

        System.out.println("===============IO==================");
        IODemoByNIO.readFileByIO(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("===============NIO==================");
        IODemoByNIO.readFileByChannel(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println("===================FileChannelReader======================");
        IODemoByNIO.readFileByChannelReader(filePath);
        System.out.println("\n耗时: " + (System.currentTimeMillis() - start) + " ms");
    }
}
