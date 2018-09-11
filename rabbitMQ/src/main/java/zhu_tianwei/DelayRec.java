package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;

/** @Author: shuyizhi @Date: 2018-08-27 13:42 @Description: 延迟队列接收端 */
public class DelayRec {
    private static final String queue_name = "test.queue";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = ConnectionUtils.channel;
        // channel.exchangeDeclare("delay.exchange", "", true);

        channel.queueDeclare(queue_name, true, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(queue_name, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            System.out.println(
                    "received message: " + message + ",date: " + System.currentTimeMillis());
        }
    }
}
