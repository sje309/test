package dbUtils;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/4 10:41
 * @Description: 数据库连接工具类
 * 参考： https://blog.csdn.net/yerenyuan_pku/article/details/52372703
 */
public class JdbcUtils {
    private static DataSource ds = null;

    static {
        try {
            Properties prop = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(inputStream);
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
            ds = factory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
