package zhu_tianwei.spring;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-30 14:52 @Description: Java Api 监控Rabbit队列 */
public class JavaAPIMonitor {

    private static String queue_name = "helloQueue";

    public static void main(String[] args)
            throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException,
                    IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        // amqp://userName:password@hostName:portNumber/virtualHost
        // factory.setUri("amqp://guest:guest@localhost:5672/");
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        System.out.println("maxChannel: " + connection.getChannelMax());

        Channel channel = connection.createChannel();
        System.out.println("channelNumber: " + channel.getChannelNumber());

        System.out.println("messageCount: " + channel.messageCount(queue_name));
        System.out.println("consumerCount: " + channel.consumerCount(queue_name));

        channel.close();
        connection.close();
    }
}
