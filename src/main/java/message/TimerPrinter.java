package message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 13:47
 * @Description:
 */
public class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("Now time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
