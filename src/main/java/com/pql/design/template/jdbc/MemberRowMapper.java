package com.pql.design.template.jdbc;

import java.sql.ResultSet;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
        Member member = new Member();
        // 字段过多 可直接采用原型模式
        member.setUsername(resultSet.getString("username"));
        member.setPassword(resultSet.getString("password"));
        member.setAge(resultSet.getInt("age"));
        member.setAddr(resultSet.getString("addr"));
        return member;
    }
}
