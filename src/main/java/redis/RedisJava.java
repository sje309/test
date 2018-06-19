package redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/9 15:58
 * @Description:
 */
public class RedisJava {
    private static final Jedis jedis = new Jedis("192.168.56.101");

    public static void main(String[] args) {
        //Jedis jedis = new Jedis("192.168.56.101");
        //System.out.println("连接成功");
        //System.out.println("服务器正在运行: " + jedis.ping());
        //
        ////jedis.set("mykey", "http://wwww.baidu.com");
        ////jedis.mset("key1", "value1", "key2", "value2");
        //System.out.println(StringUtils.join(jedis.mget("key1", "key2"), "&"));

        //jedisHash();

        //jedesList();

        //jedisSet();

        //jedisSortSet();

        //dels("*dest");

        //region Json数组
        //List<UserDo> userDoList = new ArrayList<>();
        //UserDo userDo1 = new UserDo();
        //userDo1.setUserId(1);
        //userDo1.setUname("shuyizhi");
        //userDo1.setSex(0);
        //userDo1.setEmail("shuyizhi@zxisl.com");
        //
        //UserDo userDo2 = new UserDo();
        //userDo2.setUserId(2);
        //userDo2.setUname("tangdou");
        //userDo2.setSex(0);
        //userDo2.setEmail("tangdou@zxisl.com");
        //
        //userDoList.add(userDo1);
        //userDoList.add(userDo2);
        //
        //JSONArray array = new JSONArray();
        //array.addAll(userDoList);
        //boolean result = setJsonArray("users", array);
        //if (result) {
        //    System.out.println("插入成功");
        //} else {
        //    System.out.println("插入失败");
        //}
        //endregion

        System.out.println(JSON.parse(getJsonArray("users")));

    }

    public static void jedisHash() {
        //region hset hgetAll
        //jedis.hset("userinfo1", "name", "束义志");
        //jedis.hset("userinfo1", "address", "安徽省合肥市望江西路与创新大道交叉口");
        //jedis.hset("userinfo1", "email", "shuyizhi@zxisl.com");
        //System.out.println("userinfo1的所有filed的内容为: " + jedis.hgetAll("userinfo1"));
        //endregion
        //region hmset hgetall
        Map<String, String> map = new HashMap<>();
        map.put("name", "shuyizhi");
        map.put("address", "AnhuiHefei");
        map.put("email", "394604592@qq.com");
        jedis.hmset("userinfo2", map);
        //System.out.println("userinfo2的所有field的内容为: " + jedis.hmget("userinfo2", "name", "address", "email"));
        System.out.println("userinfo2的所有fileds的内容为: " + jedis.hvals("userinfo2"));
        //endregion
    }

    public static void jedesList() {
        jedis.lpush("db", "MySQL", "Redis", "MongoDB");
        System.out.println("db的内容为: " + jedis.lrange("db", 0, 10));

        jedis.rpush("db", "SQLServer", "Oracle", "PostSQL");
        System.out.println("右插入后的db: " + jedis.lrange("db", 0, 10));
    }

    /**
     * 无序集合 Set
     * SAdd key member1 [member2]:向集合中添加一个或多个成员
     * Scard key: 获取集合中的成员数
     * Sdiff key1[key2]: 返回给定所有集合的差集
     * Sdiffstore destination key1 [key2]: 返回给定所有集合的差集并存储在destination中
     * Sinter key1 [key2]: 返回给定所有集合的交集
     * Sinterstore destination key1 [key2]:返回给定所有集合的交集并存储在destination中
     * Sismember key member: 判断member元素是否是集合key的成员
     * Smembers key: 返回集合中的所有成员
     * Smove source destination member: 将member元素从source集合移动到destination集合
     * Spop key: 移除并返回集合中的一个随机元素
     * SRandmember key [count]:返回集合中给一个或者多个随机数
     * Srem key member1 [member2]:移除集合中一个或多个成员
     * Sunion key1 [key2]: 返回所有给定集合的并集
     * Sunionstore destination key1 [key2]: 所有给定集合的并集存储到destination集合中
     * Sscan key cursor[Match pattern][COUNT count]:迭代集合中的元素
     */
    public static void jedisSet() {
        String[] members = {"合肥", "合肥", "北京", "上海", "天津", "苏州"};
        jedis.sadd("city", members);
        System.out.println("集合中的成员数: " + jedis.scard("city") + "所有的成员为: " + jedis.smembers("city"));

        String[] members1 = {"合肥", "上海", "重庆", "南京", "广州", "西安"};
        jedis.sadd("city1", members1);

        System.out.println("city和city1的差集为: " + jedis.sdiff("city", "city1"));
        System.out.println("差集存储在diffdest中: ");
        jedis.sdiffstore("diffdest", "city", "city1");
        System.out.println(jedis.smembers("diffdest"));

        System.out.println("city和city1的交集为: " + jedis.sinter("city", "city1"));
        System.out.println("交集存储在interdest中: ");
        jedis.sinterstore("interdest", "city", "city1");
        System.out.println(jedis.smembers("interdest"));

        System.out.println("city和city1的并集为: " + jedis.sunion("city", "city1"));
        System.out.println("并集存储在uniondest中： ");
        jedis.sunionstore("uniondest", "city", "city1");
        System.out.println(jedis.smembers("uniondest"));

        System.out.println("jedis.sscan: " + jedis.sscan("city", "").getResult());
    }

    /**
     * 有序集合
     * ZADD key score1 member1 [score2 member2]
     * 向有序集合添加一个或多个成员，或者更新已存在成员的分数
     * 2	ZCARD key
     * 获取有序集合的成员数
     * 3	ZCOUNT key min max
     * 计算在有序集合中指定区间分数的成员数
     * 4	ZINCRBY key increment member
     * 有序集合中对指定成员的分数加上增量 increment
     * 5	ZINTERSTORE destination numkeys key [key ...]
     * 计算给定的一个或多个有序集的交集并将结果集存储在新的有序集合 key 中
     * 6	ZLEXCOUNT key min max
     * 在有序集合中计算指定字典区间内成员数量
     * 7	ZRANGE key start stop [WITHSCORES]
     * 通过索引区间返回有序集合成指定区间内的成员
     * 8	ZRANGEBYLEX key min max [LIMIT offset count]
     * 通过字典区间返回有序集合的成员
     * 9	ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT]
     * 通过分数返回有序集合指定区间内的成员
     * 10	ZRANK key member
     * 返回有序集合中指定成员的索引
     * 11	ZREM key member [member ...]
     * 移除有序集合中的一个或多个成员
     * 12	ZREMRANGEBYLEX key min max
     * 移除有序集合中给定的字典区间的所有成员
     * 13	ZREMRANGEBYRANK key start stop
     * 移除有序集合中给定的排名区间的所有成员
     * 14	ZREMRANGEBYSCORE key min max
     * 移除有序集合中给定的分数区间的所有成员
     * 15	ZREVRANGE key start stop [WITHSCORES]
     * 返回有序集中指定区间内的成员，通过索引，分数从高到底
     * 16	ZREVRANGEBYSCORE key max min [WITHSCORES]
     * 返回有序集中指定分数区间内的成员，分数从高到低排序
     * 17	ZREVRANK key member
     * 返回有序集合中指定成员的排名，有序集成员按分数值递减(从大到小)排序
     * 18	ZSCORE key member
     * 返回有序集中，成员的分数值
     * 19	ZUNIONSTORE destination numkeys key [key ...]
     * 计算给定的一个或多个有序集的并集，并存储在新的 key 中
     * 20	ZSCAN key cursor [MATCH pattern] [COUNT count]
     * 迭代有序集合中的元素（包括元素成员和元素分值）
     */
    public static void jedisSortSet() {
        Map<String, Double> map = new HashMap<>();
        map.put("MySQL", 10.0);
        map.put("SQLServer", 11.0);
        map.put("Redis", 9.0);
        map.put("MongoDB", -5.0);

        jedis.zadd("runoobkey", map);
        System.out.println("有序集合中的元素为： " + jedis.zscan("runoobkey", ""));
    }

    /**
     * 批量删除
     * 对应的redis命令:redis-cli keys "*dest" | xargs redis-cli del
     *
     * @return
     */
    public static boolean dels(String pattern) {
        Set<String> set = jedis.keys(pattern);
        String keys = "";
        long result = 0l;
        if (null != set && !set.isEmpty()) {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                keys += iterator.next() + "&";
            }
            result = jedis.del(keys.split("&"));
            System.out.println("result: " + result);
        }
        return result > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean delkeys(String pattern) {
        Set<String> set = jedis.keys(pattern);
        String keys = "";
        long result = 0l;
        if (null != set && !set.isEmpty()) {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                keys += iterator.next() + "&";
            }
            result = jedis.del(keys.split("&"));
            System.out.println("result: " + result);
        }
        return result > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 插入Json数组
     *
     * @param key
     * @param array
     * @return
     */
    public static boolean setJsonArray(String key, com.alibaba.fastjson.JSONArray array) {
        String values = JSON.toJSONString(array);
        return jedis.set(key, values) == null ? Boolean.FALSE : Boolean.TRUE;
    }

    public static String getJsonArray(String key) {
        return jedis.get(key);
    }
}
