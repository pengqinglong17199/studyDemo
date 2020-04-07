package com.pql.design.strategy.promotion;

/**
 * 优惠券抵扣
 * */
public class CouponStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券,课程价格直接减优惠券面值抵扣");
    }


}
