package com.pql.design.proxy.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CglibSignlogDynamicProxy implements MethodInterceptor {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyMM");

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        setTabale(objects[0]);
        return methodProxy.invokeSuper(o, objects);
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
