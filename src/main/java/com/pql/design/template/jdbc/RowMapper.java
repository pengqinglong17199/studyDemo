package com.pql.design.template.jdbc;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet resultSet, int rowNum)throws Exception;
}
