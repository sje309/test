package timertask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:57
 * @Description:
 */
public class SynchroTest {
    public static void main(String[] args) {
        TimerTask task = new SynchroTimerTask();
        Timer timer = new Timer();
        //timer.schedule(task, 1 * 1000);
        timer.schedule(task, 1 * 1000, 2 * 1000);
    }
}
