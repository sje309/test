import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: shuyizhi @Date: 2018-06-27 10:45 @Description: 消息的生产者
 * 参考:https://www.cnblogs.com/LipeiNet/p/5977028.html
 */
public class Producer {
    public static final String QUEUE_NAME = "JavaClient.rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        /** 创建连接工厂 */
        ConnectionFactory factory = new ConnectionFactory();
        /** 设置RabbitMQ相关信息 */
        factory.setHost("localhost");
        /** 创建一个新的连接 */
        Connection connection = factory.newConnection();
        /** 创建一个通道 */
        Channel channel = connection.createChannel();
        /** 声明一个队列 */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ Java Client";
        /** 发送消息到队列 */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("Producer Send +'" + message + "'");
        /** 关闭资源 */
        channel.close();
        connection.close();
    }
}
