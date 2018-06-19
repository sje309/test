package thread;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 14:01
 * @Description: 捕获线程异常
 */
public class TestThreadException {
    /*public static void main(String[] args) {
        System.out.println("begin main");
        Thread thread = new Thread(() -> {
            int i = 1 / 0;
        }, "myThread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("%s发生异常%s", t.getName(), e.getMessage()));
            }
        });
        thread.start();
        System.out.println("end main");
    }*/

    public static void main(String[] args) {
        System.out.println("begin main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        }, "mythread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("%s发生异常%s", t.getName(), e.getMessage()));
                System.out.println(String.format("%s发生了异常%s", t.getName(), e.getMessage()));
            }
        });
        thread.start();
        System.out.println("end main");
    }
}
