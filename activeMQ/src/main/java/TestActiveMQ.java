/**
 * @Author: shuyizhi
 * @Date: 2018-06-21 17:17
 * @Description: 参考：https://www.cnblogs.com/jaycekon/p/6225058.html
 */
public class TestActiveMQ {
    public static void main(String[] args) {
        Producter producter = new Producter();
        producter.init();
        TestActiveMQ testActiveMQ = new TestActiveMQ();
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testActiveMQ.new ProductorMq(producter)).start();
        //Thread 2
        new Thread(testActiveMQ.new ProductorMq(producter)).start();
        //Thread 3
        new Thread(testActiveMQ.new ProductorMq(producter)).start();
        //Thread 4
        new Thread(testActiveMQ.new ProductorMq(producter)).start();
        //Thread 5
        new Thread(testActiveMQ.new ProductorMq(producter)).start();
    }

    private class ProductorMq implements Runnable {
        Producter producter;

        public ProductorMq(Producter producter) {
            this.producter = producter;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producter.sendMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
