package com.pql.design.proxy.test;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    /**
     * 代理模式 为其他对象提供一种代理,以控制对这个对象的访问.
     * 代理对象在客户端和目标用户之间起到一个中介作用,属于结构型设计模式
     * 使用代理模式主要有两个目的
     *      1.保护目标对象
     *      2.增强目标对象
     *
     * 使用静态代理 主要完成的功能是: 根据考勤的打卡时间自动按月进行分表.
     * 根据开闭原则,我们修改原来写好的代码逻辑,通过代理对象来完成
     *
     * 静态代理的缺陷 只能为固定的对象进行代理,有局限性 无法适应复杂的业务,
     * 如果有多个不同的业务对象需要进行分表,此时静态代理需要多个代理类分别去代理对象
     * 这个时候就可以使用动态代理.功能更加强大
     *
     * 动态代理 同一种按月分表的代理 可以给到所有有分表业务的对象进行实现,
     * 只要对象有分表的必要条件 getCreateTime() 因为分表需要根据时间来运算 即可完成代理
     * */
    public static void main(String[] args) {
        try{
            Signlog signlog = new Signlog();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2020-04-02");
            signlog.setCreateTime(date.getTime());

             /*SISignlogService signlogService = new SignlogServiceSaticProxy();
            int id = signlogService.createOrder(signlog);
            System.out.println("考勤记录id:" + id +"\n");

            ISignlogService signlogService2 =
                    (ISignlogService)new JDKSignlogServiceDynamicProxy().getInstance(new SignlogService());
            signlogService2.createOrder(signlog);
            System.out.println("考勤记录id:" + id);*/

            ISignlogService signlogService3 = (ISignlogService) new CglibSignlogDynamicProxy().getInstance(SignlogService.class);
            System.out.println("考勤记录id:" + signlogService3.createOrder(signlog));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
