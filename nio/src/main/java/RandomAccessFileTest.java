import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: shuyizhi @Date: 2018-08-08 11:05 @Description: RandomAccessFile
 * 参考：http://www.cnblogs.com/xiaoxi/p/6483390.html
 */
public class RandomAccessFileTest {
    /**
     * 将Employees数据写入指定的文件
     *
     * @param employees Employees数组
     * @param filePath 写入的文件路径
     * @throws IOException
     */
    public static void wirteFile(Employee[] employees, String filePath) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(filePath, "rw");
        for (Employee employee : employees) {
            accessFile.writeBytes(employee.getName());
            accessFile.writeInt(employee.getAge());
        }
        accessFile.close();
    }

    /**
     * @param filePath
     * @throws IOException
     */
    public static void readFile(String filePath) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(filePath, "r");
        System.out.println(accessFile.readLine());
    }
}
