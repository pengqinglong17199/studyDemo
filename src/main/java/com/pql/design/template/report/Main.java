package com.pql.design.template.report;

public class Main {

    /**
     * 模板模式是指 定义一个算法的股价,并允许子类为一个或者多个步骤提供实现. 使得子类可以在不改变算法结构的情况下重新定义算法的某些步骤
     *
     * 模板模式适用于以下场景
     *      1. 一次性实现一个算法的不变部分,并将可变的行为留给子类来实现.
     *      2. 各子类中公共的行为被提取出来并集中到一个公共的父类中,从而避免代码重复
     *
     * 模板模式的优点
     *      1. 利用模板模式将相同处理逻辑的代码放到抽象父类中,可以提高代码的复用性
     *      2. 将不同的代码放到不同的子类中,通过对子类的拓展增加新的行为,可以提高代码的拓展性
     *      3. 把不变的行为写在父类中,去除子类的重复代码,提供了一个很好的代码复用平台, 符合开闭原则
     *
     * 模板模式的缺点
     *      1. 每个抽象类都需要一个子类来实现, 导致子类的数量增加
     *      2. 类数量的增加间接的增加了系统的复杂性;
     *      3. 因为继承关系的缺点,如果父类添加新的抽象方法,所有子类都要改一遍
     * */
    public static void main(String[] args) {
        BaseReportService reportService= new ShenZhenReportService();
        reportService.report();

        System.out.println();

        reportService = new WuHanReportService();
        reportService.report();
    }
}
