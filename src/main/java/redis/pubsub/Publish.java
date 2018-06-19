package redis.pubsub;

import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 10:33
 * @Description: 消息的发布者
 * 参考：https://blog.csdn.net/KingCat666/article/details/77883813
 */
public class Publish {
    private Jedis publisherJedis;
    private String channel;

    public Publish(Jedis publisherJedis, String channel) {
        this.publisherJedis = publisherJedis;
        this.channel = channel;
    }

    public void startPublish() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("请输入message: ");
                String line = reader.readLine();
                if (!"quit".equals(line)) {
                    publisherJedis.publish(channel, line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
