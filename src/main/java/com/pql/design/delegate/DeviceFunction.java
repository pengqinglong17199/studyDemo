package com.pql.design.delegate;

/**
 * 函数方法
 * */
@FunctionalInterface
public interface DeviceFunction {

    void execute(DeviceCmdLog cmdLog);
}
