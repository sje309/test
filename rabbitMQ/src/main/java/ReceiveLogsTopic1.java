import com.rabbitmq.client.*;
import com.rabbitmq.client.Consumer;
import org.apache.commons.lang.ArrayUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-22 11:17 @Description: */
public class ReceiveLogsTopic1 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) {
        // String[] routingKeys = new String[] {"*.orange.*"};
        String[] routingKeys = new String[] {"*.*.rabbit", "lazy.#"};
        receivedTopic(routingKeys);
    }

    private static void receivedTopic(String[] routingKeys) {
        if (ArrayUtils.isEmpty(routingKeys)) {
            throw new IllegalArgumentException("参数错误:routingKey为null");
        }
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();

            for (String routingKey : routingKeys) {
                channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
                System.out.println(
                        "ReceiveLogsTopic exchange:"
                                + EXCHANGE_NAME
                                + ", queue:"
                                + queueName
                                + ", BindRoutingKey:"
                                + routingKey);
            }
            System.out.println("ReceiveLogsTopic Waiting for messages......");

            Consumer consumer =
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(
                                String consumerTag,
                                Envelope envelope,
                                AMQP.BasicProperties properties,
                                byte[] body)
                                throws IOException {
                            String message = new String(body, Charset.forName("UTF-8"));
                            System.out.println(
                                    "ReceiveLogsTopic Received '"
                                            + envelope.getRoutingKey()
                                            + "':'"
                                            + message
                                            + "'");
                        }
                    };

            channel.basicConsume(queueName, true, consumer);

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
