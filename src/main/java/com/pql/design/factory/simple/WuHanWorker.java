package com.pql.design.factory.simple;

public class WuHanWorker implements IWorker {

    @Override
    public void report() {
        System.out.println("上报武汉劳工");
    }
}
