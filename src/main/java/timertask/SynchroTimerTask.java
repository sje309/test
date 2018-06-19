package timertask;

import java.util.TimerTask;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 14:56
 * @Description:
 */
public class SynchroTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Synchor data to other servers.");
    }
}
