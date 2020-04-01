package com.pql.principle.kaibi;

public class OpenCloseTest {
    public static void main(String[] args) {
        ICourse course = new JavaDiscountCourse(1, "java", 100d);
        System.out.println(course.getPrice());
    }
}
