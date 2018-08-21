import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: shuyizhi @Date: 2018-08-20 14:50 @Description: ActiveMQ JMS API
 * 参考：https://www.cnblogs.com/Peter2014/p/8118811.html
 */
public class MessageSender {
    public static void main(String[] args) {
        createQueue();
    }

    public static void createQueue() {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer messageProducer;

        connectionFactory =
                new ActiveMQConnectionFactory(
                        ActiveMQConnectionFactory.DEFAULT_USER,
                        ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                        ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Peter_Test_Queue");
            messageProducer = session.createProducer(destination);
            /** 设置是否持久化 */
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMsg(session, messageProducer);
            /** 事务性提交 */
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMsg(Session session, MessageProducer messageProducer)
            throws JMSException {
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage("ActiveMQ 发送的消息 " + i);
            System.out.println("发送消息: ActiveMQ发送的消息 " + i);
            messageProducer.send(message);
        }
    }
}
