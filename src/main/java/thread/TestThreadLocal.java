package thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-21 10:59
 * @Description: ThreadLocal
 * 参考:http://www.cnblogs.com/dolphin0520/p/3920407.html
 */
public class TestThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {

        //region ThreadLocal
        //final TestThreadLocal test = new TestThreadLocal();
        //test.set();
        //System.out.println("test.getLong(): " + test.getLong());
        //System.out.println("test.getString(): " + test.getString());
        //
        //Thread thread1 = new Thread() {
        //    @Override
        //    public void run() {
        //        test.set();
        //        System.out.println(test.getLong());
        //        System.out.println(test.getString());
        //    }
        //};
        //thread1.start();
        //thread1.join();
        //
        //System.out.println("test.getLong(): " + test.getLong());
        //System.out.println("test.getString(): " + test.getString());
        //endregion

        //region 同步容器
        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList插入10000000条数耗时: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Vector插入10000000条数据耗时: " + (end - start) + "ms");
        //endregion
    }

}

