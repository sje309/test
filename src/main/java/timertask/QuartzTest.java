package timertask;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 11:14
 * @Description: 使用Quartz进行任务调度
 */
public class QuartzTest implements Job {
    //实现需要执行的任务
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Generating report - "
                + jobExecutionContext.getJobDetail().getDescription()
                + ", type=" + jobExecutionContext.getJobDetail().getJobDataMap().getString("type"));
        System.out.println(new Date().toString());
    }

    public static void main(String[] args) {

    }
}
