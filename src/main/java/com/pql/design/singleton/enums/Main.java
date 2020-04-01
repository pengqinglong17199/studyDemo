package com.pql.design.singleton.enums;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    /**
     * 注册单例模式之枚举单例模式
     *      枚举类型通过类名和类对象类找到一个唯一的枚举对象,因此枚举对象不可能被类加载器加载多次
     *      在反射的newInstance()方法中也有强制性的判断,如果修饰符是枚举类型,则直接抛出异常
     *      jdk枚举的语法特殊性以及反射也为枚举保驾护航,让枚举式单例成为一种比较优雅的实现
     * */
    public static void main(String[] args) {
        try{
            // 尝试序列化破坏单例
            EnumSingleton instance1 = null;
            EnumSingleton instance2 = EnumSingleton.getInstance();
            instance2.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingleton) ois.readObject();

            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
