package com.pql.design.observer.student;

import java.util.Observable;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 9:46
 */
public class JAVAStudent extends Observable {

    private String name = "java生态圈";
    private static JAVAStudent javaStudent = null;

    public static JAVAStudent getInstance(){
        if(null == javaStudent){
            javaStudent = new JAVAStudent();
        }
        return javaStudent;
    }

    public String getName(){
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUsername() + "在" + this.name + "上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
