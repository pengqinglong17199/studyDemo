package com.pql.design.strategy.promotion;

/**
 * 返现促销
 * */
public class CashbackStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销, 返现金额转到银行卡");
    }


}
