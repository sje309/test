package redis;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/11 14:45
 * @Description:
 */
public class TaskProducer implements Runnable {
    Jedis jedis = new Jedis("192.168.56.101", 6379);

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(600) + 600);
                UUID taskId = UUID.randomUUID();        //模拟生成一个任务
                jedis.lpush("task-queue", taskId.toString());
                System.out.println("插入了一个新的任务: " + taskId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
