package message;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 10:25
 * @Description: 模拟消息
 * 参考：https://blog.csdn.net/luoweifu/article/details/45568411
 */
public class TestMessage {
    private static ArrayBlockingQueue<Message> msgQueue = new ArrayBlockingQueue<Message>(100);

    public static void main(String[] args) {
        WindowSimulator windowSimulator = new WindowSimulator(msgQueue);
        //产生消息
        windowSimulator.generateMsg();
        //消息循环
        Message msg = null;
        while ((msg = msgQueue.poll()) != null) {
            ((MessageProcess) msg.getSource()).doMessage(msg);
        }
    }
}
