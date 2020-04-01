package com.pql.design.factory.abastract;

public class ShenZhenWorker implements IWorker {
    @Override
    public void report() {
        System.out.println("深圳上报劳工");
    }
}
