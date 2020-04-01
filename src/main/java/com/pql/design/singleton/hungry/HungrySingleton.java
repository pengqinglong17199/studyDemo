package com.pql.design.singleton.hungry;

public class HungrySingleton {

    private static final HungrySingleton hungrySingleton1 = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance1(){
        return hungrySingleton1;
    }

    private static final HungrySingleton hungrySingleton2;
    static{
        hungrySingleton2 = new HungrySingleton();
    }

    public static HungrySingleton getInstance2(){
        return hungrySingleton2;
    }

}
