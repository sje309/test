import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-22 14:21 @Description: fanout消费者 */
public class FanoutExchangeRecv {
    private static final String QUEUE_NAME = "test_queue_fanout_1";
    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args)
            throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /** 绑定队列到交换器::不设置路由键 */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        /** 同一时刻服务器只会发送一条消息给消费者 */
        channel.basicQos(1);
        /** 定义队列的消费者 */
        QueueingConsumer consumer = new QueueingConsumer(channel);
        /** 监听队列 */
        channel.basicConsume(QUEUE_NAME, false, consumer);
        /** 获取消息 */
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            System.out.println("前台系统: '" + message + "'");
            Thread.sleep(1 * 1000);
            /** 手动返回 */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
