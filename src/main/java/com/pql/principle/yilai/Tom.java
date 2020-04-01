package com.pql.principle.yilai;

public class Tom {

    public void study(ICourse course){
        course.study();
    }

    public void studyJavaCourse(){
        System.out.println("学习java");
    }

    public void studyPythonCourse(){
        System.out.println("学习python");
    }

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.studyJavaCourse();
        tom.studyPythonCourse();

        ICourse course = new JavaCourse();
        tom.study(course);
        course = new PythonCourse();
        tom.study(course);
    }
}
