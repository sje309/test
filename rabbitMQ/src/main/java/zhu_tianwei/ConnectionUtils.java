package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-24 13:48 @Description: */
public class ConnectionUtils {
    public static ConnectionFactory factory;
    public static Connection connection;
    public static Channel channel;

    /** 定义Exchange 类型 */
    public static final String TOPIC = "topic";

    public static final String FANOUT = "fanout";
    public static final String DIRECT = "direct";
    public static final String HEADERS = "headers";

    static {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭channel和connection
     *
     * @param channel
     */
    public static void close(Channel channel) {
        try {
            if (null != channel) {
                channel.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
