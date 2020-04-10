package com.pql.design.decorator;

/**
 * @author 彭清龙
 * @date 2020-04-09 下午 20:00
 */
public class EggDecorator extends BatterackeDecorator {


    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
