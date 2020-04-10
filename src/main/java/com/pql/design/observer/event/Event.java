package com.pql.design.observer.event;

import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Method;

/**
 * 监听器的一种包装，标准事件源格式的定义
 * @author 彭清龙
 * @date 2020-04-10 上午 10:24
 */
@Getter
@ToString
public class Event {

    // 事件源 事件是由谁发起的
    private Object source;
    // 事件触发 要通知谁
    private Object target;
    // 事件触发 要做什么动作 回调
    private Method callback;
    // 事件的名称 触发的是什么事件
    private String trigger;
    // 事件触发的时间
    private long time;

    public Event(Object target, Method callback){
        this.target = target;
        this.callback = callback;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

}
