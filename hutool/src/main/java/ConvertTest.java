import cn.hutool.core.convert.Convert;

/** @Author: shuyizhi @Date: 2018/11/2 16:19 @Description: */
public class ConvertTest {
    public static void main(String[] args) {
        String[] b = {"1", "2", "3", "4"};
        String bStr = Convert.toStr(b);
        System.out.println("bStr: " + bStr);
        /** 半角转全角 */
        String a = "123456789";

        // 结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);
        System.out.println("sbc: " + sbc);
    }
}
