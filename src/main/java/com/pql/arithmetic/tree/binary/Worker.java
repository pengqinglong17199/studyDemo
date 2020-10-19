package com.pql.arithmetic.tree.binary;

/**
 * 模拟工人类
 * @author 彭清龙
 * @date 2020/10/19 16:14
 */
public class Worker implements Sort {

    private int id;
    private String name;
    private int age;
    private String sex;

    public Worker(int id, String name, int age, String sex){
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int hash() {
        return id;
    }
}
