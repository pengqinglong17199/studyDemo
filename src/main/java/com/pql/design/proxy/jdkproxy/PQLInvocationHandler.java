package com.pql.design.proxy.jdkproxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 * 手写jdk动态代理
 * */
public interface PQLInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
