package com.pql.design.decorator;

/**
 * @author 彭清龙
 * @date 2020-04-09 下午 20:01
 */
public class SausageDecorator extends BatterackeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+ "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
