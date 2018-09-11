package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;

/** @Author: shuyizhi @Date: 2018-08-24 14:11 @Description: */
public class RecLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = ConnectionUtils.channel;
        channel.exchangeDeclare(EXCHANGE_NAME, ConnectionUtils.TOPIC);
        String queueName = channel.queueDeclare().getQueue();
        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.queueBind(queueName, EXCHANGE_NAME, "*.warning", null);
        channel.basicConsume(queueName, consumer);

        System.out.println(" [*] Waiting for messages about kernel. To exit press CTRL+C");

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.out.println("匹配的routingKey为: " + delivery.getEnvelope().getRoutingKey());
            System.out.println(
                    "获取的信息为: " + new String(delivery.getBody(), Charset.forName("UTF-8")));
        }
    }
}
