package com.pql.design.proxy.test;

public class SignlogDao {
    public int insert(Signlog signlog){
        System.out.println("dao保存考勤记录成功");
        return 1;
    }
}
