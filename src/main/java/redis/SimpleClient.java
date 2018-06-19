package redis;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 16:11
 * @Description: Redis 简单测试
 * 参考：https://blog.csdn.net/jiangtao_st/article/details/37699473
 */
public class SimpleClient {
    public static void main(String[] args) {
        //<editor-fold desc="缓存中插入对象">
        UserDo userDo = new UserDo();
        userDo.setEmail("shuyizhi@zxisl.com");
        userDo.setSex(1);
        userDo.setUname("shuyizhi");
        userDo.setUserId(10);
        boolean resultCache = RedisClient.set("zhuoxuan", userDo);
        if (resultCache) {
            System.out.println("向缓存中保存对象成功!");
        } else {
            System.out.println("向缓存中保存对象失败!");
        }

        //从缓存中获取对象
        userDo = RedisClient.get("zhuoxuan", UserDo.class);
        if (null != userDo) {
            System.out.println("从缓存中获取对象成功!");
            System.out.println(userDo.toString());
        }
        //</editor-fold>

        //RedisClient.setList();
    }
}
