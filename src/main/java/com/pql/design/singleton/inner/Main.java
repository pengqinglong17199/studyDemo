package com.pql.design.singleton.inner;

import com.pql.design.singleton.lazy.LazySimpleSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    /**
     * 静态内部类单例模式  通过吸收饿汉与懒汉的优点 完美屏蔽掉内存浪费以及性能问题的两个缺点
     *      内部类在类被调用时进行加载,同时静态保证在方法调用前完成初始化,巧妙的避免了线程安全问题
     * */
    public static void main(String[] args) throws Exception {
        // 反射破坏单例
        Constructor<InnerClassSingleton> c = InnerClassSingleton.class.getDeclaredConstructor(null);
        c.setAccessible(true);

        InnerClassSingleton lazySimpleSingleton = c.newInstance();
        InnerClassSingleton lazySimpleSingleton1 = c.newInstance();

        System.out.println(lazySimpleSingleton);
        System.out.println(lazySimpleSingleton1);
    }
}
