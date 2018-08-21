import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/** @Author: shuyizhi @Date: 2018-08-20 15:02 @Description: 消息接受 */
public class MessageRecevied {
    public static void main(String[] args) {
        receivedMsg();
    }

    public static void receivedMsg() {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory =
                new ActiveMQConnectionFactory(
                        ActiveMQConnectionFactory.DEFAULT_USER,
                        ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                        ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("Peter_Test_Queue");
            messageConsumer = session.createConsumer(destination);
            while (true) {
                TextMessage txtMsg = (TextMessage) messageConsumer.receive(100);
                if (null != txtMsg) {
                    System.out.println("收到消息====" + txtMsg.getText());
                } else {
                    break;
                }
            }
        } catch (JMSException ex) {

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
}
