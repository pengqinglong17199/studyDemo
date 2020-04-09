package com.pql.design.adapter.reform;

/**
 * token登录
 * */
public class LoginForTokenAdapter implements LoginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("token登录");
        return null;
    }
}
