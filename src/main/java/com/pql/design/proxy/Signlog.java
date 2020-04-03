package com.pql.design.proxy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Signlog {
    private Object orderInfo;
    private Long createTime;
    private String id;
}
