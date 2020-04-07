package com.pql.design.strategy.promotion;

/**
 * 无优惠
 * */
public class EmptyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }


}
