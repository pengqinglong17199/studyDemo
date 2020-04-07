package com.pql.design.delegate.spring;

public class UserController {

    private static String url = "user";

    public void login(){
        System.out.println("登录");
    }

    public void logout(){
        System.out.println("登出");
    }
}
