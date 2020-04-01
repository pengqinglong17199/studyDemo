package com.pql.design.factory.simple;

public class Main extends ReportWorkerFactory {

    /**
     * 简单工厂模式指的是 由一个工厂对象决定创建哪一种产品类的实例，但他不属于Gof的23种设计模式。
     * 简单工程模式适用于工厂类负责创建的对象较少的场景，而且客户端只需要传入工厂类的参数，对于如何创建对象不需要关心
     *
     * 缺点在于  工厂类的智者相对过重，不易于扩展过于复杂的产品结构。
     * */
    public static void main(String[] args) {
        /*ICourse course = new JavaCourse();
        course.record();

        course = new PythonCourse();
        course.record();*/

        // 简单工厂模式
        ReportWorkerFactory factory = new ReportWorkerFactory();
        factory.create("深圳劳工").report();
        factory.create("武汉劳工").report();

        // 静态工厂模式
        ReportWorkerFactory.create("深圳劳工").report();
        ReportWorkerFactory.create("武汉劳工").report();

        // 反射创建
        create(ShenZhenWorker.class).report();
        create(WuHanWorker.class).report();
    }
}
