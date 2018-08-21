/** @Author: shuyizhi @Date: 2018-08-20 16:36 @Description: */
public class VariaTest {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // for (int i = 0; i < 6000; i++) {
        //    // new Thread(() -> count++).start();
        //    MyThread1 thread = new MyThread1();
        //    Thread t = new Thread(thread);
        //    t.start();
        // }
        // Thread.sleep(4 * 1000);
        // System.out.println("count: " + count);

    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        VariaTest.count++;
    }
}
