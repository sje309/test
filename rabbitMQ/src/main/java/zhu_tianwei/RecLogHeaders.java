package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** @Author: shuyizhi @Date: 2018-08-24 15:03 @Description: exchange类型为headers 消息接受端 */
public class RecLogHeaders {
    private static final String EXCHANGE_NAME = "headers_logs";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = ConnectionUtils.channel;
        channel.exchangeDeclare(EXCHANGE_NAME, ConnectionUtils.HEADERS);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "", null);

        Map<String, Object> map = new HashMap<>();
        map.put("x-match", "any");
        map.put("aaa", "1111");
        map.put("bbb", "2222");

        com.rabbitmq.client.AMQP.BasicProperties properties =
                new com.rabbitmq.client.AMQP.BasicProperties();
        properties.builder().headers(map);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            BookModel model = (BookModel) SerializationUtils.deserialize(delivery.getBody());
            System.out.println("接受的消息： " + model.toString());

            // Set<String> set = delivery.getProperties().getHeaders().keySet();
            // for (String s : set) {
            //    System.out.println(
            //            "key: "
            //                    + s
            //                    + "---> value: "
            //                    + delivery.getProperties().getHeaders().get(s));
            // }

            Map<String, Object> consumerHeaders = delivery.getProperties().getHeaders();
            for (String key : consumerHeaders.keySet()) {
                System.out.println("key: " + key + "===>value: " + consumerHeaders.get(key));
            }
        }
    }
}
