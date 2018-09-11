package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-24 11:21 @Description: */
public class RecLogDirect {
    private static final String EXCHANGE_NAME = "ex_logs_direct";
    private static final String[] SERVICES = {"info", "warning", "error"};

    public static void main(String[] args) {
        try {
            recMsgByDirect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void recMsgByDirect() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        String service = getService();
        channel.queueBind(queueName, EXCHANGE_NAME, service, null);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        System.out.println("开始接受......");
        System.out.println("channelNumber: " + channel.getChannelNumber());
        System.out.println("consumerCount: " + channel.consumerCount(queueName));


        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            System.out.println("接受的消息为: " + message);
            //delivery.getEnvelope().
        }
    }

    public static String getService() {
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SERVICES[2];
    }
}
