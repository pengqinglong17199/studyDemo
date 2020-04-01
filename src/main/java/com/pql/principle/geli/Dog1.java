package com.pql.principle.geli;

public class Dog1 implements IAnimal1 {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        System.out.println("游泳");
    }
}
