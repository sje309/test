import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-22 14:34 @Description: 交换机类型为fanout，传递对象数组看看 */
public class FanoutObjSend {
    private static final String EXCHANGENAME = "fanout_exchange_object";
    private static final int COUNT = 20;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /** 声明fanout类型的交换机 */
        channel.exchangeDeclare(EXCHANGENAME, "fanout");

        for (int i = 0; i < COUNT; i++) {
            Book book = new Book();
            book.setPublishDate(new Date());
            book.setId(i + 1);
            book.setAuthor("shuyizhi" + (i + 1));
            book.setName("Thinking In Java");
            book.setPrice(15.2 * (i + 1));
            /** 发送消息 */
            channel.basicPublish(EXCHANGENAME, "", null, SerializationUtils.serialize(book));
            System.out.println("[X] Send '" + book.toString() + "'");
        }
        /** 关闭资源 */
        channel.close();
        connection.close();
    }
}
