package zhu_tianwei;

import com.rabbitmq.client.Channel;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** @Author: shuyizhi @Date: 2018-08-24 14:47 @Description: exchange类型为headers发送信息 */
public class SendLogHeaders {
    private static final String EXCHANGE_NAME = "headers_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = ConnectionUtils.channel;
        channel.exchangeDeclare(EXCHANGE_NAME, ConnectionUtils.HEADERS);

        BookModel model = new BookModel();
        model.setAuthorName("束义志");
        model.setBookName("高等数学工专");
        model.setId(100);
        model.setPrice(25.6);
        model.setPublishDate(new Date(2001, 02, 26));

        Map<String, Object> map = new HashMap<>(16);
        map.put("aaa", "1111");

        com.rabbitmq.client.AMQP.BasicProperties properties =
                new com.rabbitmq.client.AMQP.BasicProperties();
        properties.builder().headers(map);

        channel.basicPublish(EXCHANGE_NAME, "", properties, SerializationUtils.serialize(model));
        System.out.println("发送的消息为: " + model.toString());
        ConnectionUtils.close(channel);
    }
}
