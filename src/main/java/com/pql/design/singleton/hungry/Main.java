package com.pql.design.singleton.hungry;

public class Main {

    /**
     * 饿汉式单例 绝对的线程安全 在线程还没有出现以前就实例化了,不可能存在访问安全问题.
     *
     * 优点: 没有加任何锁,执行效率比较高,用户体验比懒汉式单例更好
     *
     * 缺点: 类加载的时候就初始化,不管用与不用都占着空间,浪费了内存,有可能占着茅坑不拉屎
     *
     * */
    public static void main(String[] args) {
        /**
         * 写法一
         * 先静态 后动态
         * 先属性 后方法
         * 先 上  后 下
         */
        HungrySingleton instance1A = HungrySingleton.getInstance1();
        System.out.println(instance1A);
        HungrySingleton instance1B = HungrySingleton.getInstance1();
        System.out.println(instance1B);

        /**
         * 写法二
         * 静态代码块机制
         * */
        HungrySingleton instance2A = HungrySingleton.getInstance2();
        System.out.println(instance2A);
        HungrySingleton instance2B = HungrySingleton.getInstance2();
        System.out.println(instance2B);
    }
}
