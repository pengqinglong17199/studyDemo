package com.pql.design.adapter.reform;

/**
 * 微信登录
 * */
public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("微信登录");
        return null;
    }
}
