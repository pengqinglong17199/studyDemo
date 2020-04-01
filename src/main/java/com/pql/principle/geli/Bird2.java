package com.pql.principle.geli;

public class Bird2 implements IFlyAnimal2 {
    @Override
    public void fly() {
        System.out.println("飞");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
