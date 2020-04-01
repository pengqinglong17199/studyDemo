package com.pql.design.singleton.lazy;

public class LazySimpleSingleton {

    private LazySimpleSingleton(){}

    private static LazySimpleSingleton lazy = null;

    public static LazySimpleSingleton getInstance1(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

    public synchronized static LazySimpleSingleton getInstance2(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

    public  static LazySimpleSingleton getInstance3(){
        if(lazy == null){
            synchronized (LazySimpleSingleton.class) {
                if (lazy == null) {
                    lazy = new LazySimpleSingleton();
                }
            }
        }
        return lazy;
    }
}
