package com.pql.design.strategy.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付工厂
 * */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String JD_PAY = "JDPay";
    public static final String DEFAULT_PAY = "AliPay";
    private static Map<String, Payment> PAYMENT_MAP = new HashMap<>();

    static {
        PAYMENT_MAP.put(ALI_PAY, new AliPay());
        PAYMENT_MAP.put(WECHAT_PAY, new WechatPay());
        PAYMENT_MAP.put(UNION_PAY, new UnionPay());
        PAYMENT_MAP.put(JD_PAY, new JDPay());
    }

    public static Payment get(String payKey){
        if(!PAYMENT_MAP.containsKey(payKey)){
            return PAYMENT_MAP.get(DEFAULT_PAY);
        }
        return PAYMENT_MAP.get(payKey);
    }
}
