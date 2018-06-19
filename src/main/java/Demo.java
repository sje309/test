import static test.Common.AGE;
import static test.Common.outPut;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/23 10:01
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Integer c = 25;
        int a = AGE;
        System.out.println(a);
        outPut();
        System.out.println(sum(1, 2));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(new int[]{1, 2, 3, 4}));
    }

    private static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
