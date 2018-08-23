import com.rabbitmq.client.*;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-22 10:25 @Description: 获取Logs */
public class RecLogs {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) {
        new Thread(
                        () -> {
                            try {
                                RecLogs.receivedLogs("logs1");
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (TimeoutException e) {
                                e.printStackTrace();
                            }
                        })
                .start();

        new Thread(
                        () -> {
                            try {
                                RecLogs.receivedLogs("logs2");
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (TimeoutException e) {
                                e.printStackTrace();
                            }
                        })
                .start();
    }

    public static void receivedLogs(String name) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 产生一个随机的队列名称
        String queueName = channel.queueDeclare().getQueue();
        // 对队列进行绑定
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(name + " Waiting for messages");
        Consumer consumer =
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag,
                            Envelope envelope,
                            AMQP.BasicProperties properties,
                            byte[] body)
                            throws IOException {
                        String message = new String(body, "UTF-8");
                        System.out.println(name + " Received '" + message + "'");
                    }
                };
        // 队列会自动删除
        channel.basicConsume(queueName, true, consumer);
        // 关闭资源
        // channel.close();
        // connection.close();
    }
}
