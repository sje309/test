package zhu_tianwei;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.UUID;

/** @Author: shuyizhi @Date: 2018-08-24 13:44 @Description: exchange 类型为topic日志发送端 */
public class SendLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = ConnectionUtils.channel;
        channel.exchangeDeclare(EXCHANGE_NAME, ConnectionUtils.TOPIC);
        // 定义绑定键
        String[] routing_keys =
                new String[] {"kernal.info", "cron.warning", "auth.info", "kernel.critical"};
        for (String routingKey : routing_keys) {
            String msg = UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
            System.out.println("[x] Send routingKey: '" + routingKey + "',msg= '" + msg + "'");
        }
        ConnectionUtils.close(channel);
    }
}
