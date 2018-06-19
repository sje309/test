package redis;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/11 14:57
 * @Description: 生成消费任务调度
 * 参考：https://blog.csdn.net/zuoanyinxiang/article/details/50263945
 */
public class TaskSchedulerSystem {
    public static void main(String[] args) {
        //启动一个生产者线程，模拟任务的产生
        new Thread(new TaskProducer()).start();
        try {
            Thread.sleep(15 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动一个消费者线程，模拟任务的处理
        new Thread(new TaskConsumer()).start();

        //主线程休眠
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
