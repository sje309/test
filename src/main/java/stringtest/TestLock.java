package stringtest;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: shuyizhi @Date: 2018-08-16 15:35 @Description: 可重入锁
 * 参考：https://www.cnblogs.com/dolphin0520/p/3923167.html
 */
public class TestLock {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private static final int COUNT = 5;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final TestLock test = new TestLock();

        // new Thread(() -> test.insert(Thread.currentThread())).start();
        // new Thread(() -> test.insert(Thread.currentThread())).start();

        // new Thread(() -> test.insertByTryLock(Thread.currentThread())).start();
        // new Thread(() -> test.insertByTryLock(Thread.currentThread())).start();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> test.insert(Thread.currentThread()));
        service.execute(() -> test.insert(Thread.currentThread()));

        service.shutdown();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            /** 清空一下,防止输出有重叠 */
            arrayList.clear();
            for (int i = 0; i < COUNT; i++) {
                arrayList.add(i);
            }
        } catch (Exception ex) {

        } finally {
            // 输出
            System.out.println(ArrayUtils.toString(arrayList));
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    public void insertByTryLock(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
                /** 清空一下,防止输出有重叠 */
                arrayList.clear();
                for (int i = 0; i < COUNT; i++) {
                    arrayList.add(i);
                }
            } catch (Exception ex) {

            } finally {
                System.out.println(ArrayUtils.toString(arrayList));
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获得所失败");
        }
    }
}
