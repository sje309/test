import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: shuyizhi @Date: 2018-10-26 11:14 @Description:
 */
public class RedisTest {
    MySql mySql = new MySql();
    Redis redis = new Redis();
    ResultSet rs = null;

    @Test
    public void test() throws SQLException {
        int id = 1;
        String sql = "Select * from t_user where id=" + id;
        String userName = "";
        if (redis.hexists("user_" + id, "username_")) {
            userName = redis.hget("user_" + id, "username_");
            System.out.println("Welcome Redis! User" + userName + "login success!");
        } else {
            rs = mySql.connection.createStatement().executeQuery(sql);
            if (rs.next() == false) {
                System.out.println("Mysql no register,Please register first");
            } else {
                userName = rs.getString("userName");
                System.out.println("Welcome MySql! User" + userName + "login success");
                redis.hset("user_" + id, "username_", userName);
                /** 设置过期时间 */
                redis.expire("user_" + id, 30 * 60);
            }
        }
    }

    @Test
    public void testLocal() throws SQLException {
        int id = 4;
        String sql = "select * from users where id=" + id;
        String name = "";
        if (redis.hexists("user_" + id, "user_name")) {
            name = redis.hget("user_" + id, "username_");
            System.out.println("Welcome Redis! user" + name + "login success!");
        } else {
            rs = mySql.connection.createStatement().executeQuery(sql);
            if (rs.next() == false) {
                System.out.println("MySql no register,Please register first");
            } else {
                name = rs.getString("name");
                System.out.println("Welcome MySql! User" + name + " login success");
                /**设置redis缓存*/
                redis.hset("user_" + id, "username_", name);
                /**设置过期时间*/
                redis.expire("user_" + id, 30 * 60);
            }
        }
    }
}
