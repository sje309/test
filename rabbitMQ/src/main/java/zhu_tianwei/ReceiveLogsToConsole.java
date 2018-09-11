package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-24 9:43 @Description: 控制台打印接受的消息 */
public class ReceiveLogsToConsole {
    private static final String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args)
            throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "", null);

        channel.basicConsume(queueName, true, consumer);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            System.out.println("[x] Recevied '" + message + "'");
        }
    }
}
