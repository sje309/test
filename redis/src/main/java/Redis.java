import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @Author: shuyizhi @Date: 2018-10-26 10:30 @Description: Redis作为MySQL缓存
 * 参考：https://jingyan.baidu.com/article/09ea3ede1dd0f0c0aede3938.html
 */
public class Redis extends Jedis {
    public Jedis redis;

    {
        redis = new Jedis("127.0.0.1", 6379);
        // redis.auth("zxsoft");
    }

    @Override
    public String get(String key) {
        return redis.get(key);
    }

    @Override
    public String set(String key, String value) {
        return redis.set(key, value);
    }

    @Override
    public Long del(String... keys) {
        return redis.del(keys);
    }

    @Override
    public Long append(String key, String str) {
        return redis.append(key, str);
    }

    @Override
    public Boolean exists(String key) {
        return redis.exists(key);
    }

    @Override
    public Long setnx(String key, String val) {
        return redis.setnx(key, val);
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return redis.setex(key, seconds, value);
    }

    public Long setrange(String key, int offset, String str) {
        return redis.setrange(key, offset, str);
    }

    @Override
    public List<String> mget(String... keys) {
        return redis.mget(keys);
    }

    @Override
    public String mset(String... keys) {
        return redis.mset(keys);
    }

    @Override
    public Long msetnx(String... keyvalues) {
        return redis.msetnx(keyvalues);
    }

    public String getset(String key, String value) {
        return redis.getSet(key, value);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return redis.hmset(key, hash);
    }

    public Map<String, String> hgetall(String key) {
        return redis.hgetAll(key);
    }

    @Override
    public String hget(final String key, final String field) {
        return redis.hget(key, field);
    }

    @Override
    public Long hset(final String key, final String field, final String value) {
        return redis.hset(key, field, value);
    }

    @Override
    public Long expire(final String key, final int seconds) {
        return redis.expire(key, seconds);
    }

    @Override
    public Boolean hexists(final String key, final String field) {
        return redis.hexists(key, field);
    }
}
