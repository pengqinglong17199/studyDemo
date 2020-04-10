package com.pql.design.decorator;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 9:19
 */
public abstract class BatterackeDecorator extends Battercake {

    // 静态代理 委派
    private Battercake battercake;

    public BatterackeDecorator(Battercake battercake){
        this.battercake = battercake;
    }

    protected  abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
