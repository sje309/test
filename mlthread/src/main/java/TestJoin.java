/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 11:05
 * @Description: 参考：http://www.importnew.com/26850.html
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
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
        B.start();
    }

    /**
     * @param threadName
     */
    private static void printNumber(String threadName) {
        int i = 0;
        while (i < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
            i++;
        }
    }
}
