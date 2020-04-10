package com.pql.design.decorator;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 9:11
 */
public class BaseBattercake extends Battercake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
