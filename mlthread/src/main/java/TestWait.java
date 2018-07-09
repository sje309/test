/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 11:15
 * @Description: wait()、notify()测试，实现线程交叉打印
 * 参考：http://www.importnew.com/26850.html
 */
public class TestWait {
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A2");
                    System.out.println("A3");
                }
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //bPrint("B");
                synchronized (lock) {
                    System.out.println("B1");
                    System.out.println("B2");
                    System.out.println("B3");
                    lock.notify();
                }
            }
        });

        aThread.start();
        bThread.start();
    }

    /**
     * A线程打印
     *
     * @param threadName 线程名称
     */
    private synchronized static void aPrint(String threadName) {
        System.out.println(threadName + "1");
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + "2");
        System.out.println(threadName + "3");
    }

    /**
     * B线程打印
     *
     * @param threadName 线程名称
     */
    private synchronized static void bPrint(String threadName) {
        System.out.println(threadName + "1");
        System.out.println(threadName + "2");
        System.out.println(threadName + "3");
        lock.notify();
    }
}
