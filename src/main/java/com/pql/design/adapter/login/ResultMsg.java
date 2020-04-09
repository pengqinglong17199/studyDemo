package com.pql.design.adapter.login;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultMsg {

    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
