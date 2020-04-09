package com.pql.design.adapter.reform;

/**
 * 手机号登录
 * */
public class LoginForTelAdapter implements LoginAdapter{


    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("手机号登录");
        return null;
    }
}
