package com.pql.principle.lishi;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);

        Square square = new Square();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(square);
    }

    public static void resize(Quadrangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.getHeight();
            System.out.println("width：" + rectangle.getWidth() + ",height" + rectangle.getHeight());
        }
        System.out.println("方法结束"+"\nwidth：" + rectangle.getWidth() + ",height" + rectangle.getHeight());
    }
}
