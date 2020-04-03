package com.pql.design.prototype.shallow;
import java.util.ArrayList;

public class Main {
    /**
     *
     * 浅克隆 只适合完整的复制了值类型数据,没有赋值引用对象.等于所有的引用对象仍然指向原来的内存地址,
     *        此时如果修改引用对象内的属性 克隆的所有对象内的引用对象都会发生改变
     * */
    public static void main(String[] args) {
        // 创建对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(18);
        concretePrototype.setName("彭清龙");
        concretePrototype.setHobbies(new ArrayList());
        // 克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA prototype = (ConcretePrototypeA)client.startClone(concretePrototype);
        // 内存地址比较
        System.out.println(prototype);
        System.out.println(concretePrototype);
        // 引用对象比较
        System.out.println(prototype.getHobbies());
        System.out.println(concretePrototype.getHobbies());
        System.out.println("引用对象地址比较:" + (prototype.getHobbies() == concretePrototype.getHobbies()));
        // 修改引用对象属性后再进行比较
        prototype.getHobbies().add("123");
        concretePrototype.getHobbies().add("456");
        System.out.println(prototype.getHobbies());
        System.out.println(concretePrototype.getHobbies());
        System.out.println("引用对象地址比较:" + (prototype.getHobbies() == concretePrototype.getHobbies()));
    }
}
