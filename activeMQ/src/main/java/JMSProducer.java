import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: shuyizhi @Date: 2018-08-17 17:19 @Description: 消息的生产者(发送者)
 * 参考：https://blog.csdn.net/jiuqiyuliang/article/details/48608237
 * https://blog.csdn.net/jiuqiyuliang/article/details/48608237
 * https://blog.csdn.net/songfeihu0810232/article/details/78648706
 * https://www.cnblogs.com/xuyatao/p/6864109.html
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageProducer messageProducer;
        try {
            /** 实例化连接工厂 */
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
            /** 创建连接 */
            connection = connectionFactory.createConnection();
            /** 启动连接 */
            connection.start();
            /** 创建session */
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            /** 创建一个消息队列 */
            destination = session.createQueue("ActiveMQ1");
            /** 创建消息生产者 */
            messageProducer = session.createProducer(destination);
            /** 发送消息 */
            sendMessage(session, messageProducer);

            session.commit();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(Session session, MessageProducer messageProducer)
            throws JMSException {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage message = session.createTextMessage("MQ" + i);
            /** 发送TextMessage */
            messageProducer.send(message);
        }
    }
}
