package com.pql.design.factory.instance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 自定义连接池
 * @getInstance() 返回Pool的唯一实例，第一次调用时将执行构造函数
 * @Pool() 构造函数调用驱动装载loadDrivers()函数；
 * @createPool() 函数创建连接池，
 * @loadDrivers() 装载驱动
 * @getConnection() 返回一个连接实例
 * @getConnection(long time) 添加时间限制
 * @freeConnection(Connection con) 将连接实例返回连接池，
 * @getNum() 返回空闲连接数
 * @getNumActive() 返回当前使用的连接数
 */
public abstract class Pool {

    public String propertiesName = "db.properties";

    private static Pool instance = null;    // 唯一单例

    protected int maxConnect = 100;         // 最大连接数 默认100

    protected int normalConnect = 10;       // 空闲连接数 默认10

    protected String driverName = null;     // 驱动字符串

    protected Driver driver = null;         // 驱动变量

    /**
     * 私有构造函数，不允许外界访问
     * */
    protected Pool(){
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化所有从配置文件中读取的成员变量
     * */
    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    /**
     * 装载注册所有jdbc驱动
     * */
    protected void loadDrivers(String driverName){
        String driverClassName = driverName;

        try {
            driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册jdbc驱动程序" + driverClassName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动程序：" + driverClassName + ",错误，" + e);
        }
    }


    /**
     * 创建连接池
     * */
    public abstract void createPool();

    /**
     * (单例模式) 返回数据库连接池pool的实例
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static synchronized Pool getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if(instance == null){
            instance = (Pool)Class.forName("com.pql.design.factory.instance.Pool").newInstance();
            instance.init();
        }
        return instance;
    }

    /**
     * 获得一个可用的连接，如果没有则创建一个连接，且小于最大连接限制
     * */
    public abstract Connection getConnection();

    /**
     * 获得一个连接，有时间限制
     * */
    public abstract Connection getConnection(long time);

    /**
     * 将连接对象返回给连接池
     * */
    public abstract void freeConnection(Connection con);

    /**
     * 返回当前空闲连接数
     * */
    public abstract int getNum();

    /**
     * 返回当前工作的连接数
     * */
    public abstract int getNumActive();

    /**
     * 撤销驱动
     * */
    protected synchronized void release(){
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销jdbc驱动程序" + driver.getClass().getName());
        } catch (SQLException e) {
            System.out.println("无法撤销jdbc驱动程序的注册:" + driver.getClass().getName());
        }
    }
}
