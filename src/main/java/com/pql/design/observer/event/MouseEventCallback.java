package com.pql.design.observer.event;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 11:43
 */
public class MouseEventCallback {
    public void onClick(Event event){
        System.out.println("==============触发鼠标单击事件============");
        System.out.println(event);
    }

    public void onDoubleClick(Event event){
        System.out.println("==============触发鼠标双击事件============");
        System.out.println(event);
    }

    public void onUp(Event event){
        System.out.println("==============触发鼠标弹起事件============");
        System.out.println(event);
    }

    public void onDown(Event event){
        System.out.println("==============触发鼠标按下事件============");
        System.out.println(event);
    }

    public void onMove(Event event){
        System.out.println("==============触发鼠标移动事件============");
        System.out.println(event);
    }

    public void onWheel(Event event){
        System.out.println("==============触发鼠标滚动事件============");
        System.out.println(event);
    }

    public void onOver(Event event){
        System.out.println("==============触发鼠标悬停事件============");
        System.out.println(event);
    }

    public void onBlur(Event event){
        System.out.println("==============触发鼠标失焦事件============");
        System.out.println(event);
    }

    public void onFocus(Event event){
        System.out.println("==============触发鼠标获焦事件============");
        System.out.println(event);
    }
}
