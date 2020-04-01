package com.pql.principle.kaibi;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginprice(){
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.6;
    }
}
