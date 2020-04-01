package com.pql.design.factory.abastract;

public class WuHanWorker implements IWorker {
    @Override
    public void report() {
        System.out.println("武汉上报劳工");
    }
}
