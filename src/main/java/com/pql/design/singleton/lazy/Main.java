package com.pql.design.singleton.lazy;

public class Main {

    /**
     * 懒汉式单例模式 特点是被外部类调用的时候内部类才会加载,
     *               但是存在线程安全隐患,需要对getInstance()方法加synchronized锁,线程多时会导致性能大幅下降
     *               最终可以采取双重检查锁的模式 但是性能影响始终存在
     * */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());
        Thread thread3 = new Thread(new ExectorThread());
        Thread thread4 = new Thread(new ExectorThread());
        Thread thread5 = new Thread(new ExectorThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println("end");
    }
}
