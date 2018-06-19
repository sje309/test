package redis;

import redis.clients.jedis.JedisPubSub;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 9:57
 * @Description: Subscriber订阅
 * 参考：https://blog.csdn.net/lihao21/article/details/48370687
 */
public class Subscriber extends JedisPubSub {
    public Subscriber() {

    }

    @Override
    public void onMessage(String s, String s1) {
        System.out.println(String.format("receive redis published message,channel %s,message %s", s, s1));
    }

    @Override
    public void onPMessage(String s, String s1, String s2) {

    }

    @Override
    public void onSubscribe(String s, int i) {
        System.out.println(String.format("subscribe redis channel success,chanel %s,subscribedChannles %d", s, i));
    }

    @Override
    public void onUnsubscribe(String s, int i) {

    }

    @Override
    public void onPUnsubscribe(String s, int i) {
        System.out.println(String.format("unsubscribe redis channel,channel %s,subscribedChannels %d", s, i));
    }

    @Override
    public void onPSubscribe(String s, int i) {

    }
}
