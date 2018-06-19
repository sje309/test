package redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 11:02
 * @Description: 测试
 */
public class TestMain {
    public static final String CHANNEL = "myChannel";
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 6379;

    private final static JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();
    private final static JedisPool JEDIS_POOL = new JedisPool(POOL_CONFIG, HOST, PORT, 0);

    public static void main(String[] args) {
        final Jedis subscriberJedis = JEDIS_POOL.getResource();
        final Jedis publisherJedis = JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();

        new Thread(() -> {
            try {
                System.out.println("Subscribing to myChannel,this thread will be block");
                subscriberJedis.subscribe(subscriber, CHANNEL);
                System.out.println("subscription ended");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        new Publish(publisherJedis, CHANNEL).startPublish();
        publisherJedis.close();

        subscriber.unsubscribe();
        subscriberJedis.close();
    }
}
