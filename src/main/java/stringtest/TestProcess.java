package stringtest;

import java.util.ArrayList;

/** @Author: shuyizhi @Date: 2018-08-16 10:35 @Description: 有关进程测试 */
public class TestProcess {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) {
        // try {
        //    // 创建进程
        //    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig/all");
        //    Process process = pb.start();
        //    Runtime.getRuntime().exec("notepad");
        //    Scanner scanner = new Scanner(process.getInputStream(), "GBK");
        //    while (scanner.hasNextLine()) {
        //        System.out.println(scanner.nextLine());
        //    }
        //    scanner.close();
        //
        // } catch (IOException e) {
        //    e.printStackTrace();
        // }

        // region 创建线程,sleep()方法调用
        // TestProcess process = new TestProcess();
        // MyThread myThread1 = process.new MyThread();
        // MyThread myThread2 = process.new MyThread();
        //
        // myThread1.start();
        // myThread2.start();
        // endregion

        // region 创建线程,join()方法调用
        // System.out.println("进入线程" + Thread.currentThread().getName());
        // TestProcess process = new TestProcess();
        // MyThreadJoin threadJoin = process.new MyThreadJoin();
        // threadJoin.start();
        // try {
        //    System.out.println("线程" + Thread.currentThread().getName() + "等待");
        //    threadJoin.join();
        //    System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        // } catch (InterruptedException e) {
        //    e.printStackTrace();
        // }
        // endregion

        // region 创建线程,interrupt()方法调用
        // TestProcess process = new TestProcess();
        // MyThreadInterrupt threadInterrupt = process.new MyThreadInterrupt();
        // threadInterrupt.start();
        // try {
        //    Thread.sleep(2 * 1000);
        // } catch (InterruptedException e) {
        //    e.printStackTrace();
        // }
        // threadInterrupt.interrupt();
        // endregion

        // region 线程同步 synchronized
        // final InsertData insertData = new InsertData();
        // new Thread(
        //                () -> {
        //                    insertData.insert(Thread.currentThread());
        //                })
        //        .start();
        //
        // new Thread(
        //                () -> {
        //                    insertData.insert(Thread.currentThread());
        //                })
        //        .start();
        //
        // new Thread(() -> insertData.insert(Thread.currentThread())).start();
        // endregion

        final InsertDataSynchronized insertDataSynchronized = new InsertDataSynchronized();

        new Thread(() -> insertDataSynchronized.insert()).start();

        new Thread(() -> InsertDataSynchronized.insert1()).start();
    }

    class MyThreadInterrupt extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠模式");
                Thread.sleep(10 * 1000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                // e.printStackTrace();
                System.out.println("得到中断异常");
            }
            System.out.println("run执行结束");
        }
    }

    class MyThreadJoin extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i: " + i);
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
                i++;
                System.out.println("i:" + i);
            }
        }
    }
}

class InsertData {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public synchronized void insert(Thread thread) {
        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getName() + "在插入数据" + i);
            arrayList.add(i);
        }
    }
}

class InsertDataSynchronized {
    public synchronized void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public static synchronized void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }
}
