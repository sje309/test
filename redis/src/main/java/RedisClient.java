import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/** @Author: shuyizhi @Date: 2018/4/13 10:05 @Description: */
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
        // 设置最大连接数据
        config.setMaxTotal(maxActive);
        // 设置最大空闲数
        config.setMaxIdle(maxIdle);
        // 设置超时时间
        config.setMaxWaitMillis(maxWait);
        // 初始化连接池
        jedisPool = new JedisPool(config, ip, port);
    }

    public static boolean set(String key, Object value) {
        Jedis jedis = null;
        boolean result = Boolean.FALSE;
        try {
            String objJson = JSON.toJSONString(value);
            jedis = jedisPool.getResource();
            jedis.set(key, objJson);
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
        long result = 0L;
        try {
            jedis = jedisPool.getResource();
            result = jedis.del(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
        return result > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Object get(String key) {
        Jedis jedis = null;
        Object object = null;
        try {
            jedis = jedisPool.getResource();
            object = jedis.get(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
        return object;
    }

    public static <T> T get(String key, Class<T> tClass) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return JSON.parseObject(value, tClass);
        } catch (Exception ex) {
            return null;
        } finally {
            jedisPool.returnBrokenResource(jedis);
        }
    }
}
