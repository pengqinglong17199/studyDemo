package com.pql.design.template.jdbc;

import java.util.List;

public class Main {
    /**
     * 以sql查询威力 每次查询的表不一样 返回的数据结构也就不一样, 我们针对不同的数据都要将其封装哼不同的实体对象
     * 而每个实体对象的封装逻辑是不一样的,但封装前和封装后的处理流程是不变的,因此可以使用模板模式来进行设计
     */
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> list = memberDao.selectAll();
        System.out.println(list);
    }
}
