import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/** @Author: shuyizhi @Date: 2018-08-20 11:14 @Description: */
public class ObjectConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        receiveMessage();
    }

    public static void receiveMessage() {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer messageConsumer = null;

        try {
            /** 实例化连接工厂 */
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
            /** 通过连接工厂获取连接 */
            connection = connectionFactory.createConnection();
            /** 启动连接 */
            connection.start();
            /** 创建session */
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            /** 创建消息队列 */
            destination = session.createQueue("objectTest");
            /** 创建消费者 */
            messageConsumer = session.createConsumer(destination);

            while (true) {
                ObjectMessage message = (ObjectMessage) messageConsumer.receive(10 * 1000);
                if (null != message) {
                    Book book = (Book) message.getObject();
                    if (null != book) {
                        System.out.println("receiveMessage: " + book.toString());
                    } else {
                        break;
                    }
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
                if (null != messageConsumer) {
                    messageConsumer.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
