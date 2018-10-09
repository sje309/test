package dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @Author: shuyizhi @Date: 2018-10-09 15:27 @Description: 封装jdbc单例模式的应用
 * 参考：https://www.cnblogs.com/cpstart/p/6034216.html
 */
public class DBUtil {
    private static String user = null;
    private static String password = null;
    private static String driver = null;
    private static String url = null;
    private static Connection connection = null;

    private static Properties properties = null;

    /** 单例模式--懒汉式（双重锁定）保证线程安全性 */
    private static DBUtil db = null;

    public DBUtil() {}

    public static DBUtil getInstance() {
        if (null == db) {
            synchronized (DBUtil.class) {
                if (null == db) {
                    db = new DBUtil();
                }
            }
        }
        return db;
    }
    /** 读取配置文件并且加载数据库驱动 */
    static {
        /** 实例化Properties 对象解析配置文件 */
        properties = new Properties();
        /** 通过类加载器读取配置文件，以字节流的形式读取 */
        InputStream inputStream =
                DBUtil.class.getClassLoader().getResourceAsStream("/config.properties");
        try {
            /** 将配置文件加载到Properties对象，进行解析 */
            properties.load(inputStream);
            /** 读取配置文件 */
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            /** 加载驱动 */
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立数据库的连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询返回List容器
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String, Object>> query(String sql, Object... params) {
        return getMaps(sql, params);
    }

    public List<Map<String, Object>> query(String sql, List<Object> params) {
        Object[] objects = new Object[params.size()];
        objects = params.toArray();
        return getMaps(sql, objects);
    }

    private List<Map<String, Object>> getMaps(String sql, Object[] params) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            /** 获得连接 */
            connection = getConnection();
            /** 获得prepareStatement对象进行预编译(?占位符) */
            pst = connection.prepareStatement(sql);
            int paramsIndex = 1;
            for (Object p : params) {
                pst.setObject(paramsIndex++, p);
            }
            /** 执行sql语句获得结果集的对象 */
            rs = pst.executeQuery();
            /** 获取结果集中列的信息 */
            ResultSetMetaData rst = rs.getMetaData();
            /** 获取结果集中列的数量 */
            int columns = rst.getColumnCount();
            /** 创建List容器 */
            List<Map<String, Object>> rstList = new ArrayList<>();
            /** 处理结果 */
            while (rs.next()) {
                /** 创建Map容器存储每一列对象的值 */
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columns; i++) {
                    map.put(rst.getColumnName(i), rs.getObject(i));
                }
                /** 将Map容器放入List容器中 */
                rstList.add(map);
            }
            return rstList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /** 关闭资源 */
            close(rs, pst, connection);
        }
        return null;
    }

    /**
     * 插入数据
     *
     * @param sql
     * @param params
     * @return
     */
    public boolean insert(String sql, Object... params) {
        return modify(sql, params);
    }

    /**
     * 更新数据
     *
     * @param sql
     * @param params
     * @return
     */
    public boolean update(String sql, Object... params) {
        return modify(sql, params);
    }

    /**
     * 删除数据
     *
     * @param sql
     * @param params
     * @return
     */
    public boolean delete(String sql, Object... params) {
        return modify(sql, params);
    }

    /**
     * 修改数据(插入insert、更新update、删除delete)
     *
     * @param sql
     * @param params
     * @return
     */
    public boolean modify(String sql, Object... params) {
        PreparedStatement pst = null;
        boolean result = Boolean.FALSE;
        try {
            connection = getConnection();
            pst = connection.prepareStatement(sql);
            int columnIndex = 1;
            for (Object object : params) {
                pst.setObject(columnIndex++, object);
            }
            /** 执行sql语句并返回结果集 */
            pst.executeUpdate();
            result = Boolean.TRUE;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pst, connection);
        }
        return result;
    }

    public long queryLong(String sql, Object... params) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            pst = connection.prepareStatement(sql);
            int paramsIndex = 1;
            for (Object p : params) {
                pst.setObject(paramsIndex++, p);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                return Long.valueOf(rs.getLong(1));
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, connection);
        }
        return 0;
    }

    /**
     * 关闭资源
     *
     * @param rs
     * @param pst
     * @param connection
     */
    public static void close(ResultSet rs, PreparedStatement pst, Connection connection) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != pst) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
