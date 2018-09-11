package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Author: shuyizhi @Date: 2018-08-24 10:57 @Description: Exchange类型为direct，发送日志端
 * 参考:https://blog.csdn.net/zhu_tianwei/article/details/40887755
 */
public class SendLogDirect {
    private static final String EXCHANGE_NAME = "ex_logs_direct";
    private static final String[] SERVICES = {"info", "warning", "error"};

    public static void main(String[] args) {
        try {
            sendMsgByDirect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void sendMsgByDirect() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        /** 发送6条消息 */
        for (int i = 0; i < 6; i++) {
            String service = getService();
            String message = "'" + service + "'" + UUID.randomUUID().toString() + ".logs";
            channel.basicPublish(EXCHANGE_NAME, service, null, message.getBytes());
            System.out.println("发送的信息为: " + message);
        }
        channel.close();
        connection.close();
    }

    public static String getService() {
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SERVICES[2];
    }
}
