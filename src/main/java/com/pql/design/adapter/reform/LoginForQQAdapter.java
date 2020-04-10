package com.pql.design.adapter.reform;

/**
 * qq登录
 * */
public class LoginForQQAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("qq登录");
        return null;
    }
}
