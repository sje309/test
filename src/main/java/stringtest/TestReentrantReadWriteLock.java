package stringtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: shuyizhi @Date: 2018-08-16 17:04 @Description: ReentrantReadWriteLock
 * 参考：https://www.cnblogs.com/dolphin0520/p/3923167.html
 */
public class TestReentrantReadWriteLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        // TestReentrantReadWriteLock test = new TestReentrantReadWriteLock();

        // new Thread(() -> test.getReader(Thread.currentThread())).start();
        // new Thread(() -> test.getReader(Thread.currentThread())).start();

        // new Thread(() -> test.getReaderByLock(Thread.currentThread())).start();
        // new Thread(() -> test.getReaderByLock(Thread.currentThread())).start();

        // try {
        //    httpTest();
        // } catch (IOException e) {
        //    e.printStackTrace();
        // }
    }

    public static void httpTest() throws IOException {
        URL url = new URL("https://blog.csdn.net/u013247322/article/details/70874238");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(10 * 1000);
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String res = reader.readLine();
        while (res != null) {
            System.out.println(res);
            res = reader.readLine();
        }
        reader.close();
        inputStream.close();
        connection.disconnect();
    }

    public synchronized void getReader(Thread thread) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName() + "正在进行读操作");
        }
        System.out.println(thread.getName() + "读操作完毕");
    }

    public void getReaderByLock(Thread thread) {
        lock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } catch (Exception ex) {

        } finally {
            lock.readLock().unlock();
        }
    }
}
