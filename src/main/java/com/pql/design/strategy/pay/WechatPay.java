package com.pql.design.strategy.pay;

public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
