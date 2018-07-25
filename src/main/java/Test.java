import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Test {

    public static void main(String[] args) {
        String filePath = "D:\\test.txt";
        try {
            // System.out.println(FileUtils.readFileToString(new File(filePath),"utf-8"));
            System.out.println(StringUtils.center("未写入文件之前", 70, "="));
            System.out.println(
                    FileUtils.readFileToString(new File(filePath), Charset.forName("utf-8")));
            // FileUtils.writeStringToFile(new File(filePath), "安徽省合肥市高新区望江西路与创新大道交叉口",
            // Charset.forName("utf-8"));

            // 采用追加的方式
            FileUtils.writeStringToFile(new File(filePath), "安徽省合肥市高新区望江西路与创新大道交叉口", "utf-8", true);
            System.out.println(StringUtils.center("写入文件之后", 70, "="));
            System.out.println(
                    FileUtils.readFileToString(new File(filePath), Charset.forName("utf-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
