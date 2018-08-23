import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: shuyizhi @Date: 2018-08-22 14:04 @Description: fanout exchange
 * 参考：https://blog.csdn.net/fxq8866/article/details/62049393
 */
public class FanoutExchangeSend {
    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /** 声明交换机类型 */
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        /** 消息内容 */
        String message = "商品已经删除,id=1000";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("[X] Send' " + message + "'");
        channel.close();
        connection.close();
    }
}
