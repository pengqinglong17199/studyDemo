package com.pql.design.proxy.jdkproxy;

import com.pql.design.proxy.test.ISignlogService;
import com.pql.design.proxy.test.Signlog;
import com.pql.design.proxy.test.SignlogService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    /**
     * 手写实现jdk动态代理
     * 原理如下
     *      1. 获取被代理对象的引用,并且获取它的所有接口,反射获取
     *      2. 动态代理类重新生成一个新的类,同时新的类要实现被代理类实现的所有接口
     *      3. 动态生成java代码,新加的业务逻辑方法由一定的逻辑代码调用
     *      4. 编译新生成的java代码 .class文件
     *      5. 重新加载到jvm中运行.
     * */
    public static void main(String[] args) throws ParseException {

        Signlog signlog = new Signlog();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-04-02");

        signlog.setCreateTime(date.getTime());
        ISignlogService signlogService2 =
                (ISignlogService)new PQLSignlogServiceDynamicProxy().getInstance(new SignlogService());
        int id = signlogService2.createOrder(signlog);
        System.out.println("考勤记录id:" + id);
    }
}
