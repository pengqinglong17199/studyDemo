package com.pql.design.decorator;

/**
 * @author 彭清龙
 * @date 2020-04-09 下午 20:02
 */
public class Main {

    /**
     * 装饰者模式是指 在不改变原有对象的基础上，将功能附加到对象上，提供了比继承更有弹性的解决方案(拓展原有对象的功能)
     *
     * 装饰者模式适用于以下场景
     *      1. 拓展一个类的功能或者给一个类添加附加职责
     *      2. 动态给一个对象添加功能，这些功能可以再动态的撤销
     *
     * 装饰者模式与静态代理很相似，最大的区别在于职责不同
     * 静态代理不一定满足is-a的关系 静态代理会做功能增强 使用一个职责变得不一样
     * 装饰者模式更多的考虑的是拓展 最本子的特征是将原有类的附加功能抽离出来，简化原有类的逻辑
     *
     * 装饰者模式的优点
     *      1. 装饰者模式是继承的有力补充，且比继承灵活，可以在不改变原有对象的情况下动态的给一个对象扩展功能，即插即用
     *      2. 使用不同的装饰类及这些装饰类的排列组合，可以实现不同的效果。
     *      3. 装饰者模式完全符合开闭原则
     *
     * 装饰者模式的缺点
     *      1. 会出现更能多的代码，更多的类，增加程序的复杂性
     *      2. 动态装饰的时候，多层装饰会更复杂
     */
    public static void main(String[] args) {

        Battercake battercake = new BaseBattercake();
        System.out.println(battercake.getMsg() + "，总价格：" + battercake.getPrice());

        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg() + "，总价格：" + battercake.getPrice());

        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg() + "，总价格：" + battercake.getPrice());

        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg() + "，总价格：" + battercake.getPrice());
    }

}
