package redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/11 14:49
 * @Description:
 */
public class TaskConsumer implements Runnable {
    Jedis jedis = new Jedis("192.168.56.101", 6379);

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            String taskId = jedis.rpoplpush("task-queue", "tmp-queue");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟成功和失败的偶然现象
            if (random.nextInt(13) % 7 == 0) {
                //将本次处理失败的任务从暂存队列"tmp-queue"中，弹回任务队列"task-queue"中
                //jedis.rpoplpush("tmp-queue", "task-queue");
                jedis.rpush("task-queue", jedis.rpop("tmp-queue"));
                System.out.println(taskId + "处理失败,被弹回任务队列");
            } else {
                //将本次任务从暂停队列中移除
                if (jedis.exists(taskId)) {
                    jedis.rpop("task-queue");
                    System.out.println(taskId + "处理成功,被清除");
                }

            }
        }
    }
}
