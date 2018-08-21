import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: shuyizhi @Date: 2018-08-20 16:47 @Description: Jms接口
 * 参考：https://blog.csdn.net/a953713428/article/details/70770087
 */
public class MySender {
    public static void main(String[] args) {
        try {
            sendMsg();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMsg() throws NamingException, JMSException, IOException {
        InitialContext ctx = new InitialContext();
        QueueConnectionFactory factory =
                (QueueConnectionFactory) ctx.lookup("myQueueConnectionFactory");
        QueueConnection connection = factory.createQueueConnection();
        connection.start();
        QueueSession session =
                connection.createQueueSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) ctx.lookup("myQueue");
        QueueSender sender = session.createSender(queue);
        TextMessage message = session.createTextMessage();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter Msg,end to terminate:  ");
            String s = bufferedReader.readLine();
            if ("end".equals(s)) {
                break;
            }
            message.setText(s);
            sender.send(message);
            System.out.println("Message successfully send.");
        }
        connection.close();
    }
}
