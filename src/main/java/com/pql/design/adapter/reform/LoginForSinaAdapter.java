package com.pql.design.adapter.reform;

/**
 * 新浪微博登录
 * */
public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("新浪微博登录");
        return null;
    }
}
