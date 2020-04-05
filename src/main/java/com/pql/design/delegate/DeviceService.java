package com.pql.design.delegate;

/**
 * 指令service
 * */
public class DeviceService {

    public void create(DeviceCmdLog cmdLog){
        System.out.println("执行创建指令-->name:" + cmdLog.getName() + "---指令类型:" + cmdLog.getCmdLogType());
    }

    public void update(DeviceCmdLog cmdLog){
        System.out.println("执行更新指令-->name:" + cmdLog.getName() + "---指令类型:" + cmdLog.getCmdLogType());
    }
    public void select(DeviceCmdLog cmdLog){
        System.out.println("执行查询指令-->name:" + cmdLog.getName() + "---指令类型:" + cmdLog.getCmdLogType());
    }
    public void delete(DeviceCmdLog cmdLog){
        System.out.println("执行删除指令-->name:" + cmdLog.getName() + "---指令类型:" + cmdLog.getCmdLogType());
    }
}
