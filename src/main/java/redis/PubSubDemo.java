package redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 10:18
 * @Description:
 */
public class PubSubDemo {
    public static void main(String[] args) {
        String redisIp = "127.0.0.1";
        int redisPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, redisPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, redisPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
}
