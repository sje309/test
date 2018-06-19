package message;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 13:48
 * @Description: 使用java中Timer来在给定的时间间隔发送通知，每隔十秒打印一次数据
 * 参考：https://blog.csdn.net/liuyufeihu/article/details/51165251
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(10 * 1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "quit");
        System.exit(0);
    }
}
