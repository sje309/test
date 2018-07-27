import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @Author: shuyizhi @Date: 2018-07-26 17:05 @Description: */
public class GuavaDemo {
    static Logger logger = LogManager.getLogger(GuavaDemo.class);

    public static void main(String[] args) {
        // System.out.println("===========================普通集合测试==============================");
        // testArrayContains();
        // System.out.println("\n===========================Guava集合测试==============================");
        // testArrayContainsByGuava();
        hello();
    }

    /** 普通集合判断是否包含 */
    public static void testArrayContains() {
        int[] array = {1, 2, 3, 4, 5};
        int a = 4;
        boolean hasA = false;
        for (int i : array) {
            if (i == a) {
                hasA = true;
            }
        }
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("array中是否含有4: " + hasA);
    }

    /** Guava测试集合中是否包含 */
    public static void testArrayContainsByGuava() {
        int[] array = {1, 2, 3, 4, 5};
        int a = 4;
        boolean hasA = Ints.contains(array, a);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("array中是否包含4: " + hasA);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c", "d");
        immutableList.forEach((s -> System.out.print(s + "\t")));
        System.out.println(immutableList.getClass().toString());
    }

    public static boolean hello() {
        logger.entry(); // trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
        logger.error("Did it again!"); // error级别的信息，参数就是你输出的信息
        logger.info("我是info信息"); // info级别的信息
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        logger.log(Level.DEBUG, "我是debug信息"); // 这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.exit(); // 和entry()对应的结束方法，和logger.trace("exit");一个意思
        return false;
    }
}
