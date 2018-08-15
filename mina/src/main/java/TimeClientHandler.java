import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/** @Author: shuyizhi @Date: 2018-08-10 9:19 @Description: */
public class TimeClientHandler extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        // super.messageReceived(session, message);
        String content = message.toString();
        System.out.println("client received a message: " + content);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        // super.messageSent(session, message);
        System.out.println("sending message ->: " + message);
    }
}
