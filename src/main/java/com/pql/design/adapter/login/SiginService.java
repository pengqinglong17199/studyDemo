package com.pql.design.adapter.login;

public class SiginService {

    /**
     * 注册
     * */
    public ResultMsg register(String username, String password){
        return new ResultMsg(200, "注册成功", new Member());
    }

    /**
     * 登录
     * */
    public ResultMsg login(String username, String password){
        return null;
    }
}
