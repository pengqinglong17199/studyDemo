package com.pql.design.proxy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SignlogServiceSaticProxy implements ISignlogService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyMM");

    private ISignlogService orderService;

    public SignlogServiceSaticProxy(){
        // 假装注入
        this.orderService = new SignlogService();
    }

    @Override
    public int createOrder(Signlog signlog) {

        Long time = signlog.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到[db_" + dbRouter + "]数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        int i = orderService.createOrder(signlog);

        return i;
    }

    private void before(){
        System.out.println("proxy befpre method.");
    }

    private void after(){
        System.out.println("proxy after method.");
    }
}
