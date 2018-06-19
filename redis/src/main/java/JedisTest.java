import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/13 10:36
 * @Description:
 */
public class JedisTest {
    private static final Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) {
        jedisHash();
    }

    public static void jedisHash() {
        String key = "user:2";
        //判断user:2是否存在
        if (!jedis.hexists(key, "name") && !jedis.hexists(key, "age") &&
                !jedis.hexists(key, "address") && !jedis.hexists(key, "phone")) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "songli");
            map.put("age", "34");
            map.put("address", "安徽省巢湖市");
            map.put("phone", "13956042047");
            jedis.hmset(key, map);
        }
        System.out.println("user:2的字段数量为: " + jedis.hlen(key));

        System.out.println("user:2中的修改前age值为： " + jedis.hget(key, "age"));
        jedis.hincrBy(key, "age", 10);
        System.out.println("user:2中的修改前age值为： " + jedis.hget(key, "age"));

        //获取所有的Key
        Set<String> keys = jedis.hkeys("user:2");
        System.out.println("============user:2 keys start==============");
        if (null != keys && !keys.isEmpty()) {
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + "\t");
            }
        }
        System.out.println("\n============user:2 keys end==============");

        //获取所有的Value
        List<String> values = jedis.hvals("user:2");
        System.out.println("============user:2 values start==============");
        if (null != values && !values.isEmpty()) {
            for (String value : values) {
                System.out.print(value + "\t");
            }
        }
        System.out.println("\n============user:2 values end==============");

        //获取所有的key/value
        Map<String, String> kvMap = jedis.hgetAll("user:2");
        Set<String> ksets = kvMap.keySet();
        System.out.println("============user:2 key:value start==============");
        if (null != ksets && !ksets.isEmpty()) {
            Iterator<String> iterator = ksets.iterator();
            while (iterator.hasNext()) {
                String tmp = iterator.next();
                System.out.println("key: " + tmp + ",value: " + kvMap.get(tmp));
            }
        }
        System.out.println("\n============user:2 key:value start==============");
    
    }
}
