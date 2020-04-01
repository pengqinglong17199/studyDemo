package com.pql.design.singleton.lazy;

public class ExectorThread implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton instance1 = LazySimpleSingleton.getInstance3();
        System.out.println(Thread.currentThread().getName() + "---:---" + instance1);
    }
}
