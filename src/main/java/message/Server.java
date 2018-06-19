package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 11:23
 * @Description:
 */
public class Server {
    public void getClientMsg(CSCallBack csCallBack, String msg) {
        System.out.println("服务端：服务端接收到客户端发送的消息为: " + msg);
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务端：数据处理成功，返回成功状态 200");
        csCallBack.process("200");
    }
}
