/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 11:05
 * @Description: 参考：http://www.importnew.com/26850.html
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        /*Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });

        A.start();
        A.join();
        B.start();*/

        Thread A = new Thread(() -> {
            printNumber1("A");
        });
        Thread B = new Thread(() -> {
            printNumber1("B");
        });

        A.start();
        //A.join();
        B.start();
    }

    /**
     * @param threadName
     */

    private static void printNumber1(String threadName) {
        int i = 0;
        while (i < 3) {
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
            i++;
        }
    }
}
