package com.pql.design.strategy.promotion;

public class Main {

    /**
     * 策略模式是指 定义了算法家族并分别封装起来,让他们之间可以相互替换,此模式使得算法的变化不会影响使用算法的用户
     *
     * 策略模式的应用场景如下
     *      1.系统中有很多类,而他们的区别仅仅在于行为的不同
     *      2.一个系统需要动态的在几种算法中选择一种
     *
     * 策略模式和委派模式的区别在于 策略模式注重可拓展性, 委派模式注重内部的灵活性和可复用性
     *
     * 策略模式最好的例子就是 电商app的各种不同的优惠方案 以及网站的登录方式 和支付方式
     *      例如第三方微信登录 qq登录 微信支付 支付宝支付等等这种一个功能有多种不同的方式
     * */
    public static void main(String[] args) {
        PromotionActivity pdd = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("GROUPBUY"));
        PromotionActivity jd618 = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("COUPON"));
        PromotionActivity tm1111 = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("CASHBACK"));
        PromotionActivity tb = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(null));

        pdd.execute();
        jd618.execute();
        tm1111.execute();
        tb.execute();

    }
}
