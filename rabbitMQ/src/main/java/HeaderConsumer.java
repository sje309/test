import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: shuyizhi @Date: 2018-08-23 10:28 @Description: exchange类型为header 消费者
 * 参考：https://blog.csdn.net/zhu_tianwei/article/details/40923131
 */
public class HeaderConsumer {
    private static final String EXCHANGE_NAME = "header-exchange";
    private static final String QUEUE_NAME = "header-queue";

    public static void main(String[] args)
            throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        /** 声明转发器的类型为header */
        channel.exchangeDeclare(EXCHANGE_NAME, "headers", false, false, null);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Map<String, Object> headers = new Hashtable<>();
        /** x-match: all 或 any */
        headers.put("x-match", "any");
        headers.put("aaa", "01234");
        headers.put("bbb", "56789");

        /** 为转发器指定队列,设置binging绑定header键值对 */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "", headers);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        /** 制定接收者,第二个参数为自动应答::无需手动应答 */
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            /** 获取一下接受的header试试 */
            Map<String, Object> consumerHeaders = delivery.getProperties().getHeaders();
            for (String key : consumerHeaders.keySet()) {
                System.out.println("key: " + key + "===>value: " + consumerHeaders.get(key));
                System.out.println("key: " + key + "===>value: " + consumerHeaders.get(key));
            }

            System.out.println("接受到的消息: " + message);
        }
    }
}
