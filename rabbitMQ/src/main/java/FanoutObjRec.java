import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-22 14:50 @Description: 交换机类型fanout，接受对象 */
public class FanoutObjRec {
    private static final String EXCHANGENAME = "fanout_exchange_object";

    public static void main(String[] args)
            throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGENAME, "fanout");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGENAME, "");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        /** 监听队列 */
        channel.basicConsume(queue, false, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            Book book = (Book) SerializationUtils.deserialize(delivery.getBody());
            if (null != book) {
                System.out.println("接受的消息为： " + book.toString());
            }
        }
    }
}
