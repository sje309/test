package zhu_tianwei;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/** @Author: shuyizhi @Date: 2018-08-23 17:18 @Description: */
public class ReceiveLogsToFile {
    private static final String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args)
            throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        /** 创建一个非持久的，唯一的且自动删除的队列，队列名称由服务器随机产生，一般情况下这个名称与amq.gen-JzTY20BRgKO-HjmUJj0wLg 类似。 */
        String queueName = channel.queueDeclare().getQueue();
        /** 为转发器指定队列，设置binding */
        channel.queueBind(queueName, EXCHANGE_NAME, "", null);
        System.out.println("[*] Waiting for messages,To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            print2File(message);
        }
    }

    private static void print2File(String message) {
        try {
            String dir = ReceiveLogsToFile.class.getClassLoader().getResource("").getPath();
            String logFileName = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File file = new File(dir, logFileName + ".txt");
            FileOutputStream fos = new FileOutputStream(file, true);
            fos.write((message + "\r\n").getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
