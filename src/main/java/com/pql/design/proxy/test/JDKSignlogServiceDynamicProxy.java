package com.pql.design.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDKSignlogServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyMM");
    private  Object object;

    public Object getInstance(Object target){
        this.object = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);

    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        setTabale(objects[0]);
        Object invoke = method.invoke(object, objects);
        return invoke;
    }
    public void setTabale(Object object){
        try {
            Long time = (Long) object.getClass().getMethod("getCreateTime").invoke(object);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("动态代理类自动分配到[db_" + dbRouter + "]数据源处理数据");
            DynamicDataSourceEntry.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
