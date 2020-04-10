package com.pql.design.adapter.reform;

/**
 * 登录适配器接口
 * */
public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
