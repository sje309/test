import java.util.concurrent.CountDownLatch;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 11:29
 * @Description: CountDownLatch实例
 * 参考：http://www.importnew.com/26850.html
 * A B C 三个线程同时运行，各自独立运行完后通知 D；
 * 对 D 而言，只要 A B C 都运行完了，D 再开始运行。
 * 针对这种情况，我们可以利用 CountdownLatch 来实现这类通信方式
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        //runDAfterABC();
        testCountDownLatch();
    }

    private static void runDAfterABC() {
        int work = 3;
        CountDownLatch countDownLatch = new CountDownLatch(work);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads ");
                try {
                    countDownLatch.await();
                    System.out.println("All done,D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String TN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(TN + " is working");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(TN + " finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    private static void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3 * 1000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3 * 1000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.wait();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("主线程执行......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
