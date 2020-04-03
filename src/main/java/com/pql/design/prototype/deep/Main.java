package com.pql.design.prototype.deep;

public class Main {

    /**
     * 原型模式是指 原型实例制定创建对象的种类,并通过复制这些原型创建新的对象
     *
     * 主要适用于以下场景
     *      ①. 类初始化消耗资源较多
     *      ②. 使用new生成一个对象需要非常烦琐的过程(数据准备,访问权限等)
     *      ③. 构造函数比较复杂
     *      ④. 在循环中产生大量对象
     *
     * 深克隆 将引用对象也进行克隆 修改克隆对象中的引用对象不会影响到原对象中的引用对象
     * */
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        QiTianDaSheng deepCopy = (QiTianDaSheng) qiTianDaSheng.deepClone();
        System.out.println("深克隆: "+ (qiTianDaSheng.jinGuBang == deepCopy.jinGuBang));

        QiTianDaSheng shallowClone = qiTianDaSheng.shallowClone(qiTianDaSheng);
        System.out.println("浅克隆: "+ (qiTianDaSheng.jinGuBang == shallowClone.jinGuBang));
    }
}
