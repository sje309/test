import org.junit.Test;

/** @Author: shuyizhi @Date: 2018-07-30 14:48 @Description: */
public class IODemoByNIOTest {

    @Test
    public void readFileByChannel() {
        String filePath = "D:\\solr.json";

        long start = System.currentTimeMillis();
        IODemoByNIO.readFileByIO(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        IODemoByNIO.readFileByChannel(filePath);
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
    }
}
