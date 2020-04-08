package com.pql.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from member";
        return super.execteQuery(sql, new MemberRowMapper(), null);
    }
}
