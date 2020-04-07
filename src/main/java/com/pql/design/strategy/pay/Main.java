package com.pql.design.strategy.pay;

public class Main {

    /**
     * 策略模式是指 定义了算法家族并分别封装起来,让他们之间可以相互替换
     *             此模式使得算法的变化不会影响使用算法的用户
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
        // 虚拟订单进入后准备支付
        // 支付宝支付
        String request = PayStrategy.ALI_PAY;
        Payment payment = PayStrategy.get(request);
        PayState pay = payment.pay("1", 500);
        System.out.println(pay);

        // 微信支付
        request = PayStrategy.WECHAT_PAY;
        payment = PayStrategy.get(request);
        pay = payment.pay("1", 500);
        System.out.println(pay);
    }
}
