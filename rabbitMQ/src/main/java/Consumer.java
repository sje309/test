import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-06-27 11:03 @Description: 消息消费者 */
public class Consumer {
    public static final String QUEUE_NAME = "JavaClient.rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        /** 创建连接工厂 */
        ConnectionFactory factory = new ConnectionFactory();
        /** 设置连接属性 */
        factory.setHost("localhost");
        factory.setPassword("guest");
        factory.setUsername("guest");
        /** 创建连接 */
        Connection connection = factory.newConnection();
        /** 创建通道 */
        Channel channel = connection.createChannel();
        /** 声明队列 */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Customer Waiting Received message");
        com.rabbitmq.client.Consumer consumer =
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(
                            String consumerTag,
                            Envelope envelope,
                            AMQP.BasicProperties properties,
                            byte[] body)
                            throws IOException {
                        String message = new String(body, Charset.forName("UTF-8"));
                        System.out.println("Customer Received '" + message + "'");
                    }
                };
        /** 自动回复队列应答---Rabbit中的消息确认机制 */
        channel.basicConsume(QUEUE_NAME, true, consumer);
        /** 关闭资源 */
        channel.close();
        connection.close();
    }
}
