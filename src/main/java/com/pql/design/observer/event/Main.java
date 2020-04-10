package com.pql.design.observer.event;

/**
 * @author 彭清龙
 * @date 2020-04-10 上午 11:56
 */
public class Main {

    /**
     * 观察者模式定义了对象之间的一对多依赖，让多个观察者对象同时监听一个主体对象，当主题对象发生变化时，他的所有观察者都会收到通知并更新
     *
     * 观察者模式有时也叫发布订阅模式。观察者模式主要用于在关联行为之间建立一套触发机制的场景
     *
     * 观察者模式的优点
     *      1. 在观察者和被观察者之间简历了一个抽象的耦合。
     *      2. 观察者模式支持广播通信
     *
     * 观察者模式的缺点
     *      1. 观察者之间有过多的细节依赖，时间消耗多，程序的复杂性更高
     *      2. 使用不当会出现循环调用
     *
     * */
    public static void main(String[] args) {
        try{
            MouseEventCallback callback = new MouseEventCallback();

            // 注册事件
            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.ON_CLICK, callback);
            mouse.addLisenter(MouseEventType.ON_DOUBLE_CLICK, callback);
            mouse.addLisenter(MouseEventType.ON_BLUR, callback);

            // 调用
            mouse.click();
            mouse.doubleClick();
            mouse.blur();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
