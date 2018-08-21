import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/** @Author: shuyizhi @Date: 2018-08-20 17:20 @Description: */
public class MyReceiver {
    public static void main(String[] args) {
        try {
            receivedMsg();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void receivedMsg() throws NamingException, JMSException, InterruptedException {
        InitialContext ctx = new InitialContext();
        QueueConnectionFactory factory =
                (QueueConnectionFactory) ctx.lookup("myQueueConnectionFactory");
        QueueConnection connection = factory.createQueueConnection();
        QueueSession session =
                connection.createQueueSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) ctx.lookup("myQueue");
        QueueReceiver receiver = session.createReceiver(queue);
        /* receiver.setMessageListener(
        new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                if (null != textMessage) {
                    System.out.println(
                            "following message is received： " + textMessage.getText());
                }
            }
        });*/

        receiver.setMessageListener(
                (message) -> {
                    TextMessage textMessage = (TextMessage) message;
                    if (null != textMessage) {
                        try {
                            System.out.println(
                                    "following message is received: " + textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
        System.out.println("Receiver1 is ready, waiting for messages...");
        System.out.println("press Ctrl+c to shutdown...");
        while (true) {
            Thread.sleep(1000);
        }
    }
}
