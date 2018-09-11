package zhu_tianwei;

import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @Author: shuyizhi @Date: 2018-08-27 11:21 @Description: 延迟队列
 * 参考：https://blog.csdn.net/zhu_tianwei/article/details/53563311
 */
public class DelayProducer {
    private static final String queue_name = "test.queue";

    public static void main(String[] args) throws IOException {
        Channel channel = ConnectionUtils.channel;
        channel.queueDeclare(queue_name, true, false, false, null);
        String message = "Hello World!" + System.currentTimeMillis();
        channel.basicPublish("delay.exchange", "deal.message", null, message.getBytes());
        System.out.println("send message: '" + message + "',date: " + System.currentTimeMillis());

        ConnectionUtils.close(channel);
    }
}
