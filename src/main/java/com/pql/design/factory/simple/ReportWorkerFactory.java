package com.pql.design.factory.simple;

public class ReportWorkerFactory {

    public static IWorker create(String name){
        if("深圳".equals(name)){
            return new ShenZhenWorker();
        }else if("武汉".equals(name)){
            return new WuHanWorker();
        }else{
            return null;
        }
    }

    public static IWorker create(Class<? extends IWorker> clazz){

        try {
            if(null != clazz){
                clazz.newInstance();
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

