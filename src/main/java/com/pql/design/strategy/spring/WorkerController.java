package com.pql.design.strategy.spring;

public class WorkerController {

    private static String url = "worker";

    public void create(){
        System.out.println("创建劳工");
    }

    public void delete(){
        System.out.println("删除劳工");
    }
}
