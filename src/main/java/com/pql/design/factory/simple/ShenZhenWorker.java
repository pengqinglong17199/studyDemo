package com.pql.design.factory.simple;

public class ShenZhenWorker implements IWorker {

    @Override
    public void report() {
        System.out.println("上报深圳劳工");
    }
}
