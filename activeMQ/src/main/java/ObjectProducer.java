import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/** @Author: shuyizhi @Date: 2018-08-20 11:04 @Description: */
public class ObjectProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        createObjectMessage();
    }

    public static void createObjectMessage() {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageProducer messageProducer;
        try {
            /** 实例化连接工厂 */
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

            /** 创建连接 */
            connection = connectionFactory.createConnection();
            /** 启动连接 */
            connection.start();
            /** 创建session */
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            /** 创建一个消息队列 */
            destination = session.createQueue("objectTest");
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
        Book book = new Book();
        book.setId(100);
        book.setAuthor("束义志");
        book.setName("thinking in Java");
        book.setPrice(100.00);
        ObjectMessage message = session.createObjectMessage(book);
        System.out.println("发送消息: " + book.toString());
        messageProducer.send(message);
    }
}
