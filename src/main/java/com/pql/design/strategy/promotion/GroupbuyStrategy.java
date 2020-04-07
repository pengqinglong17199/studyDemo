package com.pql.design.strategy.promotion;

/**
 * 团购优惠
 * */
public class GroupbuyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("拼团 20人成团, 全团享受团购价");
    }


}
