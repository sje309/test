import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: shuyizhi @Date: 2018-10-26 10:03 @Description: 连接MySQL
 * 参考：https://jingyan.baidu.com/article/09ea3ede1dd0f0c0aede3938.html
 */
public class MySql {
    public Connection connection;

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/javatest?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=true",
                            "root",
                            "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
