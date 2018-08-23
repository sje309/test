import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-21 14:16 @Description: */
public class Work1 {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Worker1 Waiting for messages");
        /** 每次从队列中获取的数量 */
        channel.basicQos(1);

        final com.rabbitmq.client.Consumer consume =
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag,
                            Envelope envelope,
                            AMQP.BasicProperties properties,
                            byte[] body)
                            throws IOException {
                        String message = new String(body, Charset.forName("UTF-8"));
                        System.out.println("Work1 received message '" + message + "'");
                        try {
                            throw new Exception();
                            // doWork(message);
                        } catch (Exception e) {
                            channel.abort();
                        } finally {
                            System.out.println("Worker1 Done");
                            channel.basicAck(envelope.getDeliveryTag(), false);
                        }
                    }
                };
        boolean autoAck = false;
        // 消息消费完成确认
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, consume);
    }

    private static void doWork(String task) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
