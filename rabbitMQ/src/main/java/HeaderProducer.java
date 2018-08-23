import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: shuyizhi @Date: 2018-08-23 9:57 @Description: exchange类型为"header"
 * 参考：https://blog.csdn.net/zhu_tianwei/article/details/40923131
 */
public class HeaderProducer {
    private static final String EXCHANGE_NAME = "header-exchange";

    @SuppressWarnings(value = "deprecation")
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /** 声明转发器和类型headers */
        channel.exchangeDeclare(EXCHANGE_NAME, "headers");
        String message = new Date().toString() + ":log something";

        Map<String, Object> headers = new Hashtable<>();
        headers.put("aaa", "01234");

        com.rabbitmq.client.AMQP.BasicProperties.Builder properties =
                new com.rabbitmq.client.AMQP.BasicProperties.Builder();
        properties.headers(headers);

        /** 指定消息发送到的转发器,绑定键值对header键值对 */
        channel.basicPublish(EXCHANGE_NAME, "", properties.build(), message.getBytes());
        System.out.println("Send message: '" + message + "'");

        channel.close();
        connection.close();
    }
}
