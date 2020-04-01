package com.pql.design.factory.method;

public class Main {

    /**
     * 工厂方法模式是指 定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法模式让类的实例化推迟到子类中进行。
     *                  在工厂方法模式中用户只需要关心所需产品对应的工厂，无需关心创造细节，而且加入新的产品时符合开闭原则
     *
     * 工厂方法模式主要解决 产品扩展的问题，在简单工厂模式中，随着产品链的丰富，如果每个课程的创建逻辑有区别，则工厂的职责会变得越来越多有点像万能工厂，不便于维护。
     *                      根据单一职责原则我们将功能继续拆分，专人干专事，不同的课程由不同的工厂创建，对工厂本身也做一个抽象
     *
     * 工厂方法模式适用于以下场景
     *      ①.创建对象需要大量重复的代码；
     *      ②.应用层不依赖于产品实例如何被创建，如何被实现等细节
     *      ③.一个类通过其子类来制定创建哪个对象。
     *
     * 工厂方法模式的缺点
     *      ①.类的个数容易增多，增加复杂度
     *      ②.增加了系统的抽象性和理解难度
     *
     * */
    public static void main(String[] args) {
        IReportWorkerFactory reportFactory = new ShenZhenReportWorkerFactory();
        reportFactory.create().report();

        reportFactory = new WuHanReportWorkerFactory();
        reportFactory.create().report();
    }
}
