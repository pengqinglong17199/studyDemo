package com.pql.design.observer.student;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 9:56
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        JAVAStudent javaStudent = (JAVAStudent) o;
        Question question = (Question) arg;

        System.out.println("====================");
        System.out.println(name + "老师，你好");
        System.out.println("您收到了一个来自" + javaStudent.getName() + "的提问，希望您解答，问题内容如下:");
        System.out.println(question.getContent());
        System.out.println("提问者:" + question.getUsername());
    }
}
