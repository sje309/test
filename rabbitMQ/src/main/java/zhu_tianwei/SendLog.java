package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-23 16:26 @Description: */
public class SendLog {
    private static final String EXCHANGE_NAME = "ex_log";

    @SuppressWarnings(value = "deprecation")
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = new Date().toLocaleString() + " : log something";

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("[X] Send: '" + message + "'");

        connection.close();
        factory.clone();
    }
}
