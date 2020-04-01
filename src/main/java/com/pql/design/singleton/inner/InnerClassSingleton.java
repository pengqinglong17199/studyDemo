package com.pql.design.singleton.inner;

public class InnerClassSingleton {

    private InnerClassSingleton (){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final InnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final InnerClassSingleton LAZY = new InnerClassSingleton();
    }
}
