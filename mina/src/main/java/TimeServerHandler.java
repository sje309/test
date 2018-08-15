import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/** @Author: shuyizhi @Date: 2018-08-09 16:36 @Description: */
public class TimeServerHandler extends IoHandlerAdapter {
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        // super.sessionCreated(session);
        /** 显示客户端连接的ip地址和端口号 */
        System.out.println(session.getRemoteAddress().toString());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // super.sessionIdle(session, status);
        System.out.println("Idle: " + session.getIdleCount(status));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        // super.exceptionCaught(session, cause);
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        // super.messageReceived(session, message);
        String msg = message.toString();
        if (StringUtils.trim(msg).equalsIgnoreCase("quit")) {
            session.closeNow();
            return;
        }
        /** 返回消息字符串 */
        session.write("Hi,client");
        System.out.println("Message written: " + msg);
    }
}
