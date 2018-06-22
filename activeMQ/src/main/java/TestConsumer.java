/**
 * @Author: shuyizhi
 * @Date: 2018-06-22 9:28
 * @Description:
 */
public class TestConsumer {
    public static void main(String[] args) {
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMQ(comsumer)).start();
        new Thread(testConsumer.new ConsumerMQ(comsumer)).start();
        new Thread(testConsumer.new ConsumerMQ(comsumer)).start();
        new Thread(testConsumer.new ConsumerMQ(comsumer)).start();
    }

    private class ConsumerMQ implements Runnable {
        Comsumer comsumer;

        public ConsumerMQ(Comsumer comsumer) {
            this.comsumer = comsumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    comsumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
