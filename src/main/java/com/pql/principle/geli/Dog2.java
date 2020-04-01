package com.pql.principle.geli;

public class Dog2 implements ISwimAnimal2 {
    @Override
    public void swim() {
        System.out.println("游泳");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
