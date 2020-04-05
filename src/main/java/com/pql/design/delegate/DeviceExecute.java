package com.pql.design.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 指令执行类
 * */
public class DeviceExecute {

    private static Map<String, DeviceFunction> map = new HashMap<>();

    static{
        // 假装注入进来
        DeviceService deviceService = new DeviceService();
        map.put("create", cmdLog -> deviceService.create(cmdLog));
        map.put("update", cmdLog -> deviceService.update(cmdLog));
        map.put("select", cmdLog -> deviceService.select(cmdLog));
        map.put("delete", cmdLog -> deviceService.delete(cmdLog));


    }

    // 获取执行函数
    public static DeviceFunction getFunction(DeviceCmdLog cmdLog){
        return map.get(cmdLog.getCmdLogType());
    }
}
