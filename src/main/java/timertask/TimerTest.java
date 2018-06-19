package timertask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 10:33
 * @Description: 使用Timer进行任务调度
 * 参考：https://www.ibm.com/developerworks/cn/java/j-lo-taskschedule/
 */
public class TimerTest extends TimerTask {
    private String jobName = "";

    public TimerTest(String jobName) {
        super();
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("execute " + jobName);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay1 = 1 * 1000;
        long period1 = 1000;
        //从现在开始1S后，每隔1S执行一次Job1
        timer.schedule(new TimerTest("job1"), delay1, period1);
        long delay2 = 2 * 1000;
        long period2 = 2000;
        //从现在开始2S后，每隔2S执行一次Job1
        timer.schedule(new TimerTest("job2"), delay2, period2);
    }
}
