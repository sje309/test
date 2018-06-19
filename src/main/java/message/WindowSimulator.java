package message;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 10:14
 * @Description:
 */
public class WindowSimulator implements MessageProcess {
    private ArrayBlockingQueue msgQueue;

    public WindowSimulator(ArrayBlockingQueue msgQueue) {
        this.msgQueue = msgQueue;
    }

    public void generateMsg() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int msgType = scanner.nextInt();
            if (msgType < 0) {
                break;      //负数结束循环
            }
            String msgInfo = scanner.next();
            Message msg = new Message(this, msgType, msgInfo);
            try {
                msgQueue.put(msg);  //信息消息加入到队尾
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void onKeyDown(Message msg) {
        System.out.println("键盘事件: ");
        System.out.println("type: " + msg.getType());
        System.out.println("info: " + msg.getInfo());
    }

    public static void onMouseDown(Message msg) {
        System.out.println("鼠标事件: ");
        System.out.println("type: " + msg.getType());
        System.out.println("info: " + msg.getInfo());
    }

    public static void onSysEvent(Message msg) {
        System.out.println("系统事件: ");
        System.out.println("type: " + msg.getType());
        System.out.println("info: " + msg.getInfo());
    }

    @Override
    public void doMessage(Message message) {
        switch (message.getType()) {
            case Message.KEY_MSG:
                onKeyDown(message);
                break;
            case Message.MOUSE_MSG:
                onMouseDown(message);
                break;
            case Message.SYS_MSG:
                onSysEvent(message);
                break;
            default:
                onSysEvent(message);
                break;
        }
    }
}
