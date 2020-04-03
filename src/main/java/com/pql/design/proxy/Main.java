package com.pql.design.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    /**
     * 代理模式 为其他对象提供一种代理,以控制对这个对象的访问.
     *
     * 代理对象在客户端和目标用户之间起到一个中介作用,属于结构型设计模式
     *
     * 使用代理模式主要有两个目的
     *      1.保护目标对象
     *      2.增强目标对象
     *
     * 下面使用静态代理 主要完成的功能是: 根据考勤的打卡时间自动按月进行分表.
     * 根据开闭原则,我们修改原来写好的代码逻辑,通过代理对象来完成
     *
     * */
    public static void main(String[] args) {
        try{
            Signlog signlog = new Signlog();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2020-04-02");
            signlog.setCreateTime(date.getTime());

            ISignlogService signlogService = new SignlogServiceSaticProxy();
            int id = signlogService.createOrder(signlog);
            System.out.println("考勤记录id:" + id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
