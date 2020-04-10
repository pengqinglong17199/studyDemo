package com.pql.design.adapter.login;

public class Main {

    public static void main(String[] args) {
        SigninForThirdService service = new SigninForThirdService();
        // 不改变原来的代码 也能够兼容新的需求,还可以再加一层策略模式
        service.loginForQQ("123654");
    }
}
