package com.pql.design.delegate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceCmdLog {

    private String name;        // 姓名
    private String cmdLogType;  // 指令类型

    public DeviceCmdLog(String name, String cmdLogType){
        this.name = name;
        this.cmdLogType = cmdLogType;
    }
}
