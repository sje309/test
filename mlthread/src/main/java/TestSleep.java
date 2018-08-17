/** @Author: shuyizhi @Date: 2018-08-17 15:07 @Description: */
public class TestSleep {
    // private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) {
        TestSleep test = new TestSleep();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread3 extends Thread {
        MyThread3(String s) {
            super(s);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + ":" + i);
            }
        }
    }

    class MyThread extends Thread {
        private int i = 10;

        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i: " + i);
                try {
                    System.out.println("线程: " + Thread.currentThread().getName() + "进入睡眠状态");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程: " + Thread.currentThread().getName() + "结束睡眠状态");
                i++;
                System.out.println("i: " + i);
            }
        }
    }
}
