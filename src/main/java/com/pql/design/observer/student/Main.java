package com.pql.design.observer.student;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 10:01
 */
public class Main {

    public static void main(String[] args) {
        JAVAStudent javaStudent = JAVAStudent.getInstance();
        Teacher jackM = new Teacher("jack");
        Teacher ponyM = new Teacher("pony");

        javaStudent.addObserver(jackM);
        javaStudent.addObserver(ponyM);

        Question question = new Question();
        question.setUsername("彭清龙");
        question.setContent("观察者模式适用于哪些场景");

        javaStudent.publishQuestion(question);
    }
}
