package thread;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 13:51
 * @Description: Join
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    thread1.join();
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
