import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/** @Author: shuyizhi @Date: 2018-08-20 9:23 @Description: ActiveMQ消费者 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

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
            destination = session.createQueue("HelloWorld");
            /** 创建消费者 */
            messageConsumer = session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive(10 * 1000);
                if (null != textMessage) {
                    System.out.println("receiveMessage: " + textMessage.getText());
                } else {
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
