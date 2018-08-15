import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/** @Author: shuyizhi @Date: 2018-08-09 16:20 @Description: */
public class Handler extends IoHandlerAdapter {
    /**
     * 当一个客户端连接进入时
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        // super.sessionOpened(session);
        System.out.println("incoming client: " + session.getRemoteAddress());
    }

    /**
     * 当一个客户端连接关闭时
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // super.sessionClosed(session);
        System.out.println("one client closed");
    }

    /**
     * 当客户端发送消息到达时
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        // super.messageReceived(session, message);
        String s = message.toString();
        System.out.println("client send message is: " + s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        Date date = new Date();
        /** 返回当前时间的字符串 */
        session.write(sdf.format(date));
        System.out.println("message written...");
    }
}
