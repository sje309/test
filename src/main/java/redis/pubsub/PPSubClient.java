package redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 15:05
 * @Description:
 */
public class PPSubClient {
    private Jedis jedis;
    private JedisPubSub listener;
    private String CONSTANT_CLIENTSET = "clientSet";

    public PPSubClient(String host, int port, String clientId) {
        jedis = new Jedis(host, port);
    }
}
