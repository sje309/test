package redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 15:52
 * @Description: Redis客户端访问
 */
public class RedisClient {
    public static JedisPool jedisPool;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        int maxActive = Integer.parseInt(resourceBundle.getString("redis.pool.maxActive"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
        int maxWait = Integer.parseInt(resourceBundle.getString("redis.pool.maxWait"));
        String ip = resourceBundle.getString("redis.ip");
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(maxActive);
        //设置最大空闲数
        config.setMaxIdle(maxIdle);
        //设置超时时间
        config.setMaxWaitMillis(maxWait);
        //初始化连接池
        jedisPool = new JedisPool(config, ip, port);
    }

    public static boolean set(String key, Object value) {
        Jedis jedis = null;
        boolean result = Boolean.FALSE;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.set(key, objectJson);
            result = Boolean.TRUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
        return result;
    }

    public static boolean del(String key) {
        Jedis jedis = null;
        boolean result = Boolean.FALSE;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            result = Boolean.TRUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
        return result;
    }

    public static Object get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Object object = jedis.get(key);
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
        return null;
    }

    public static <T> T get(String key, Class<T> tClass) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return JSON.parseObject(value, tClass);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
    }

    public static void setList() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB(); // 清空数据库

        // 列表的插入与获取(可以重复)
        jedis.lpush("testList", "Redis"); // 从左边插入
        jedis.lpush("testList", "Mongodb");
        jedis.lpush("testList", "Mysql");
        jedis.lpush("testList", "Mysql");
        jedis.rpush("testList", "DB2"); // 从右边插入

        List<String> list = jedis.lrange("testList", 0, -1); // 从左到右遍历，3个参数分别是，key，开始位置，结束位置（-1代表到最后）
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取刚刚放进去的testList[%d]: %s\n", i, list.get(i));
        }

        System.out.println();
        String lpop = jedis.lpop("testList"); // 删掉最左边的那个
        String rpop = jedis.rpop("testList"); // 删掉最右边的那个
        System.out.printf("被删的左边元素是：%s，被删的右边元素是：%s\n", lpop, rpop);

        list = jedis.lrange("testList", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取被删除后的testList[%d]: %s\n", i, list.get(i));
        }

        System.out.println();
        jedis.ltrim("testList", 1, 2); // 裁剪列表，三个参数分别是，key，开始位置，结束位置
        list = jedis.lrange("testList", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取被裁剪后的testList[%d]: %s\n", i, list.get(i));
        }

        jedis.del("testList"); // 删除列表
        System.out.println("从redis删除testList后，testList是否还存在：" + jedis.exists("testList"));
        System.out.println();
        System.out.println();
        jedis.close();
    }
}
