package com.pql.design.factory.instance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.Executor;

/**
 * 数据库连接池管理类
 * */
public final class DBConnectionPool extends Pool {

    private int checkedOut; // 正在使用的连接数

    private Vector<Connection> freeConnections = new Vector<Connection>();  // 存放产生的连接对象容器

    private String passWord = null; // 密码
    private String url = null;  // 连接字符串
    private String userName = null; // 用户名
    private static int num = 0; // 空闲连接数
    private static int numAction = 0;   // 当前可用的连接数
    private static DBConnectionPool pool = null;    // 连接池实例变量

    /**
     * (单例模式) 产生数据库连接池
     * */
    public static synchronized  DBConnectionPool getInstance(){
        if(pool == null){
            pool = new DBConnectionPool();
        }
        return pool;
    }

    /**
     * 获得数据库连接实例
     */
    private DBConnectionPool(){
        try {
            init();
            // 初始化normaConn个连接
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                freeConnections.add(c);
                num++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 初始化
     * */
    private void init() throws IOException {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty("userName");
        this.passWord = p.getProperty("passWord");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    /**
     * 回收连接
     * */
    @Override
    public synchronized void freeConnection(Connection con) {
        freeConnections.addElement(con);
        num++;
        checkedOut--;
        numAction--;
        notifyAll();
    }

    /**
     * 创建一个新连接
     * */
    private Connection newConnection(){
        Connection con = null;
        try {
            if(userName == null){
                con = DriverManager.getConnection(url);
            }else {
                con = DriverManager.getConnection(url, userName, passWord);
            }
            System.out.println("连接池创建一个新的连接");
        }catch (SQLException e) {
            System.out.println("无法创建这个url的连接" + url);
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 返回当前空闲连接数
     * */
    @Override
    public int getNum() {
        return num;
    }

    /**
     * 返回当前连接数
     * */
    @Override
    public int getNumActive() {
        return numAction;
    }

    /**
     * (单例模式) 获取一个可用连接
     * */
    public synchronized Connection getConnection(){
        Connection con = null;
        if(freeConnections.size() > 0){
            num--;
            con = (Connection)freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try{
                if(con.isClosed()){
                    System.out.println("从连接池中删除一个无效连接");
                    con = getConnection();
                }
            } catch (SQLException e){
                System.out.println("从连接池中删除一个无效连接");
                con = getConnection();
            }
        }else if(maxConnect == 0 || checkedOut < maxConnect){
            con = newConnection();
        }
        if(con != null){
            checkedOut++;
        }
        numAction++;
        return con;
    }

    /**
     * 获取一个连接,并加上等待时间限制,单位为毫秒
     * */
    public synchronized  Connection getConnection(long timeout){
        long startTime = System.currentTimeMillis();
        Connection con;
        while ((con = getConnection()) == null){
            try{
                wait(timeout);
            }catch (InterruptedException e){
            }
            if((System.currentTimeMillis() - startTime) >= timeout){
                return null;
            }
        }
        return con;
    }

    public synchronized void release(){
        Enumeration<Connection> elements = freeConnections.elements();
        try {
            while (elements.hasMoreElements()) {
                Connection con = elements.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numAction = 0;
        }finally {
            super.release();
        }
    }

    /**
     * 建立连接池
     * */
    public void createPool(){
        pool = new DBConnectionPool();
        if(pool != null){
            System.out.println("创建连接池成功");
        }else{
            System.out.println("创建连接池失败");
        }
    }
}
