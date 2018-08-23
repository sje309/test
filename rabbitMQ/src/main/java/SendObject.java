import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-21 15:09 @Description: */
public class SendObject {
    private static final String QUEUE_NAME = "object Queue";

    public static void main(String[] args) {
        try {
            sendMsg();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void sendMsg() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Book book = new Book();
        book.setPrice(100.00);
        book.setName("Java编程思想");
        book.setAuthor("Java");
        book.setId(10);
        book.setPublishDate(new Date());
        /** 发送对象 */
        channel.basicPublish("", QUEUE_NAME, null, SerializationUtils.serialize(book));
        System.out.println("正在发送消息: " + book.toString());
        /** 关闭资源 */
        close(channel, connection);
    }

    public static void close(Channel channel, Connection connection) {
        if (null != channel) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        if (null != connection) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
