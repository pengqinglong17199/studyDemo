package com.pql.design.template.jdbc;

import lombok.Getter;
import lombok.Setter;

/**
 * 实体类
 * */
@Getter
@Setter
public class Member {

    private String username;
    private String password;
    private String nickName;
    private int age;
    private String addr;
}
