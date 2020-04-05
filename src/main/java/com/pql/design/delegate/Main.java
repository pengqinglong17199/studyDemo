package com.pql.design.delegate;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 委派模式是指   负责任务的调用和分配,和代理模式有点像,可以看做一种特殊情况下的静态的全权代理.
     *               但是代理模式注重过程,而委派模式注重结果
     *
     * 在spring中应用非常多, 大家常用的DispatcherServlet就用到了委派模式
     *
     * 委派模式的核心就是分发,调度,派遣
     *
     * 下面的例子 就是委派模式的一种实现 通过cmdLogType对多条指令进行执行
     * 如果不用委派模式的话 会产生大量的if else去对cmdLogType进行判断
     * 通过委派模式进行任务的分发调度省去大量的if else 也遵循了设计原则
     *
     * */
    public static void main(String[] args) {
        List<DeviceCmdLog> list = new ArrayList<>();
        list.add(new DeviceCmdLog("张三", "create"));
        list.add(new DeviceCmdLog("李四", "update"));
        list.add(new DeviceCmdLog("王五", "select"));
        list.add(new DeviceCmdLog("赵六", "delete"));

        for (DeviceCmdLog cmdLog : list) {
            DeviceFunction function = DeviceExecute.getFunction(cmdLog);
            function.execute(cmdLog);
        }
    }
}
