package com.pql.design.singleton.container;

public class Main {

    /**
     * 注册式单例之容器单例模式
     *      容器式单例模式适用于实例非常多的情况,便于管理.但是他是非线程安全的
     *      例子为 spring容器
     * */
    public static void main(String[] args) {
        Object bean1 = ContainerSingleton.getBean(Object.class.getName());
        Object bean2 = ContainerSingleton.getBean(Object.class.getName());
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
